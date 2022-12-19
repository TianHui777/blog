package com.tianhui.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tianhui.constants.SystemConstants;
import com.tianhui.dao.CommentDao;
import com.tianhui.entity.Comment;
import com.tianhui.entity.ResponseResult;
import com.tianhui.enums.AppHttpCodeEnum;
import com.tianhui.exception.SystemException;
import com.tianhui.service.CommentService;
import com.tianhui.service.UserService;
import com.tianhui.utils.BeanCopyUtils;
import com.tianhui.vo.CommentVo;
import com.tianhui.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 评论表(Comment)表服务实现类
 *
 * @author makejava
 * @since 2022-12-18 20:53:49
 */
@Service("commentService")
public class CommentServiceImpl extends ServiceImpl<CommentDao, Comment> implements CommentService {

    @Autowired
    private UserService userService;

    // 获取所有的文章评论
    @Override
    public ResponseResult commentList(String commentType, Long articleId, Integer pageNum, Integer pageSize) {
        // 查询对应文章的根评论
        LambdaQueryWrapper<Comment> queryWrapper = new LambdaQueryWrapper();
        // 对应文章：articleId,如果是友链评论，则没有articleId，因此要进行判断
        queryWrapper.eq(SystemConstants.ARTICLE_COMMENT.equals(commentType), Comment::getArticleId, articleId);

        // 根评论：rootId 为-1

        queryWrapper.eq(Comment::getRootId, -1);

        // 根据评论类型进行筛选
        queryWrapper.eq(Comment::getType, commentType);

        //分页

        Page page = new Page(pageNum, pageSize);
        page(page, queryWrapper);

        // 定义CommentVo,并拷贝获得

        List<CommentVo> commentVoList = toCommentVoList(page.getRecords());


        // 对所有的根评论进行遍历，为其设置子评论
        for (CommentVo commentVo : commentVoList) {
            //通过rootId查询子评论
            List<CommentVo> children = getChildren(commentVo.getRootId());
            //为每个根评论设置子评论
            commentVo.setChildren(children);
        }

        return ResponseResult.okResult(new PageVo(commentVoList, page.getTotal()));
    }

    /*
        新增评论
     */
    @Override
    public ResponseResult addComment(Comment comment) {
        if (!StringUtils.hasText(comment.getContent())) {
            throw new SystemException(AppHttpCodeEnum.CONTENT_NOT_NULL);
        }
        save(comment);// mybatisplus会自动填充字段
        return ResponseResult.okResult();
    }

    /*
        查询子评论
     */
    private List<CommentVo> getChildren(Long rootId) {

        LambdaQueryWrapper<Comment> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.eq(Comment::getRootId, rootId);
        queryWrapper.orderByDesc(Comment::getCreateTime);
        List<Comment> commentList = list(queryWrapper);
        // 利用CommentVo、转化方法对查询到的Comment进行封装
        List<CommentVo> commentVos = toCommentVoList(commentList);

        return commentVos;


    }


    // 定义CommentVo转化的方法
    private List<CommentVo> toCommentVoList(List<Comment> commentList) {

        // 拷贝
        List<CommentVo> commentVos = BeanCopyUtils.copyBeanList(commentList, CommentVo.class);
        for (CommentVo commentVo : commentVos) {

            // 通过toCommentUserId查询被评论的人的名字，需要用到userService，
            // 注意：如果是根评论，则toCommentUserId为-1，因此要进行判断
            if (commentVo.getToCommentId() != -1) {
                String nickName = userService.getById(commentVo.getToCommentId()).getNickName();
                commentVo.setToCommentUserName(nickName);
            } else {

                //如果为根评论，则设置为rootComment
                commentVo.setToCommentUserName("rootComment");
            }
            // 通过createBy查询被评论的人的名字，需要用到userService
            String username = userService.getById(commentVo.getCreateBy()).getNickName();
            commentVo.setUsername(username);

        }

        return commentVos;

    }
}


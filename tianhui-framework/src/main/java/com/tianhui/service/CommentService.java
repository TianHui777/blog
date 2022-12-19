package com.tianhui.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tianhui.entity.Comment;
import com.tianhui.entity.ResponseResult;

/**
 * 评论表(Comment)表服务接口
 *
 * @author makejava
 * @since 2022-12-18 20:53:49
 */
public interface CommentService extends IService<Comment> {

    // 获取所有的文章评论
    ResponseResult commentList(String commentType, Long articleId, Integer pageNum, Integer pageSize);

    // 添加评论
    ResponseResult addComment(Comment comment);
}


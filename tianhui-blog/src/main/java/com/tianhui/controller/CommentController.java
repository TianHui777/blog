package com.tianhui.controller;

import com.tianhui.constants.SystemConstants;
import com.tianhui.entity.Comment;
import com.tianhui.entity.ResponseResult;
import com.tianhui.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
public class CommentController {


    @Autowired
    private CommentService commentService;

    // 获取所有的文章评论
    @GetMapping("/commentList")
    public ResponseResult commentList(Long articleId, Integer pageNum, Integer pageSize) {

        return commentService.commentList(SystemConstants.ARTICLE_COMMENT, articleId, pageNum, pageSize);

    }


    @PostMapping

    public ResponseResult addComment(@RequestBody Comment comment) {

        return commentService.addComment(comment);
    }

    // 获取所有的文章评论
    @GetMapping("/linkCommentList")
    public ResponseResult linkCommentList(Integer pageNum, Integer pageSize) {

        return commentService.commentList(SystemConstants.LINK_COMMENT, null, pageNum, pageSize);

    }

}

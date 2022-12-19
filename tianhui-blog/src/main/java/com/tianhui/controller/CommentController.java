package com.tianhui.controller;

import com.tianhui.entity.ResponseResult;
import com.tianhui.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comment")
public class CommentController {


    @Autowired
    private CommentService commentService;

    // 获取所有的文章评论
    @RequestMapping("/commentList")
    public ResponseResult commentList(Long articleId, Integer pageNum, Integer pageSize) {

        return commentService.commentList(articleId, pageNum, pageSize);

    }

}

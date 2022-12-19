package com.tianhui.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentVo {
    private Long id;

    //评论类型（0代表文章评论，1代表友链评论）
    private String type;
    //文章id
    private Long articleId;
    //根评论id
    private Long rootId;
    //评论内容
    private String content;
    //所回复的目标评论的userId
    private Long toCommentUserId;
    //所回复的目标评论的userName
    private String toCommentUserName;
    //回复目标评论id
    private Long toCommentId;

    // 创建评论的人的Id
    private Long createBy;

    //@JsonFormat注解，格式化返回的时间格式
    @JsonFormat(timezone = "GMT+8", pattern = "yyy-MM-dd HH:mm:ss")
    private Date createTime;

    // 评论人的名字
    private String username;

    // 子评论

    private List<CommentVo> children;


}

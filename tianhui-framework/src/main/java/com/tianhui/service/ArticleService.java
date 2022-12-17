package com.tianhui.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tianhui.entity.Article;
import com.tianhui.entity.ResponseResult;

/**
 * 文章表(Article)表服务接口
 *
 * @author makejava
 * @since 2022-12-16 21:50:11
 */
public interface ArticleService extends IService<Article> {

    ResponseResult hotArticleList();

    ResponseResult articleList(Integer pageNum, Integer pageSize, Long categoryId);

    ResponseResult getArticleDetail(Long id);

}


package com.tianhui.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tianhui.entity.Article;
import org.apache.ibatis.annotations.Mapper;

/**
 * 文章表(Article)表数据库访问层
 *
 * @author makejava
 * @since 2022-12-16 21:50:10
 */

@Mapper
public interface ArticleDao extends BaseMapper<Article> {

}


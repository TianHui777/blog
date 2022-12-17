package com.tianhui.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tianhui.entity.Category;
import com.tianhui.entity.ResponseResult;

/**
 * 分类表(Category)表服务接口
 *
 * @author makejava
 * @since 2022-12-17 00:34:38
 */
public interface CategoryService extends IService<Category> {

    ResponseResult getCategoryList();
}


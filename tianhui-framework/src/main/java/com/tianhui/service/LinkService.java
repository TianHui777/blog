package com.tianhui.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tianhui.entity.Link;
import com.tianhui.entity.ResponseResult;

/**
 * 友链(Link)表服务接口
 *
 * @author makejava
 * @since 2022-12-17 16:38:54
 */
public interface LinkService extends IService<Link> {

    ResponseResult getAllLink();
}


package com.tianhui.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tianhui.entity.ResponseResult;
import com.tianhui.entity.User;

/**
 * 用户表(User)表服务接口
 *
 * @author makejava
 * @since 2022-12-18 22:01:29
 */
public interface UserService extends IService<User> {

    // 获取用户信息
    ResponseResult userInfo();

    /*
        更新用户信息
     */
    ResponseResult updateUserInfo(User user);

    ResponseResult register(User user);

}


package com.tianhui.service;

import com.tianhui.entity.ResponseResult;
import com.tianhui.entity.User;

public interface BlogLoginService {
    ResponseResult login(User user);

    ResponseResult logout();
}
package com.tianhui.controller;

import com.tianhui.entity.ResponseResult;
import com.tianhui.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/userInfo")
    public ResponseResult userInfo(){

        return userService.userInfo();

    }
}

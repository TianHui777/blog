package com.tianhui.controller;

import com.tianhui.entity.ResponseResult;
import com.tianhui.entity.User;
import com.tianhui.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/userInfo")
    public ResponseResult userInfo() {

        return userService.userInfo();

    }

    @PutMapping("/userInfo")
    public ResponseResult updateUserInfo(@RequestBody User user) {
        return userService.updateUserInfo(user);
    }

    @PostMapping("/register")
    public ResponseResult register(@RequestBody User user){

        return userService.register(user);

    }
}

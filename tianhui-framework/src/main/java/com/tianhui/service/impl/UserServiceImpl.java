package com.tianhui.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tianhui.dao.UserDao;
import com.tianhui.entity.ResponseResult;
import com.tianhui.entity.User;
import com.tianhui.service.UserService;
import com.tianhui.utils.BeanCopyUtils;
import com.tianhui.utils.SecurityUtils;
import com.tianhui.vo.UserInfoVo;
import org.springframework.stereotype.Service;

/**
 * 用户表(User)表服务实现类
 *
 * @author makejava
 * @since 2022-12-18 22:01:29
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

    /*
        获取用户信息
     */
    @Override
    public ResponseResult userInfo() {

        Long userId = SecurityUtils.getUserId();
        User user = getById(userId);
        UserInfoVo userInfoVo = BeanCopyUtils.copyBean(user, UserInfoVo.class);


        return ResponseResult.okResult(userInfoVo);
    }

    /*
        更新用户信息
     */
    @Override
    public ResponseResult updateUserInfo(User user) {
        updateById(user);
        return ResponseResult.okResult();
    }
}


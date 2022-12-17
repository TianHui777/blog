package com.tianhui.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tianhui.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户表(User)表数据库访问层
 *
 * @author makejava
 * @since 2022-12-17 16:53:29
 */

@Mapper
public interface UserDao extends BaseMapper<User> {

}


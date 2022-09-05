package com.feng.dao;

import com.feng.pojo.User;

import java.util.List;

/**
 * Created by 小冯 on 2022/8/23 0:13
 */
public interface UserDao {
    //根据ID查询用户
    User getUserById(int id);
}

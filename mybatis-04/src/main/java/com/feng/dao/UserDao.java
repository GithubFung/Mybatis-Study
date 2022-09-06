package com.feng.dao;

import com.feng.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * Created by 小冯 on 2022/8/23 0:13
 */
public interface UserDao {
    //根据ID查询用户
    User getUserById(int id);

    //分页1
    List<User> getUserByLimit(Map<String,Integer> map);

    //分页2
    List<User> getUserByRowBounds();
}

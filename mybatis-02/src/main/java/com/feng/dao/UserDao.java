package com.feng.dao;

import com.feng.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * Created by 小冯 on 2022/8/23 0:13
 */
public interface UserDao {

    //查询全部用户
    List<User> getUserList();

    //根据ID查询用户
    User getUserById(int id);

    //插入一个用户
    int addUser(User user);

    //修改用户
    int updateUser(User user);

    //删除用户
    int deleteUser(int id);
}

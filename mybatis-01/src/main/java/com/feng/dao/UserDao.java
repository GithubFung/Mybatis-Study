package com.feng.dao;

import com.feng.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * Created by 小冯 on 2022/8/23 0:13
 */
public interface UserDao {

    //模糊查询
    List<User> getUserLike(Map<String, Object> map);

    //查询全部用户
    List<User> getUserList();

    //根据ID查询用户
    User getUserById(int id);

    //万能Map
    User getUserById2(Map<String, Object> map);

    //插入一个用户
    int addUser(User user);

    //万能Map
    int addUser2(Map<String, Object> map);

    //修改用户
    int updateUser(User user);

    //删除用户
    int deleteUser(int id);
}

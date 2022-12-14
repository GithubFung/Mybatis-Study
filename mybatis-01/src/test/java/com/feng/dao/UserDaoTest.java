package com.feng.dao;

import com.feng.pojo.User;
import com.feng.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 小冯 on 2022/8/23 0:26
 */
public class UserDaoTest {
    @Test
    public void getUserLike(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("pwd","%456%");//模糊查询注意加%号
        //最好在UserMapper中，"%"{#pwd}"%"，写死
        List<User> userList = mapper.getUserLike(map);
        for(User user:userList){
            System.out.println(user);
        }
        sqlSession.close();
    }
    @Test
    public void getUserList() {
        //1.获取SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            //2.执行SQL
            //方式一：getMapper
//        UserDao userDao = sqlSession.getMapper(UserDao.class);
//        List<User> userList = userDao.getUserList();
            //方式二：老方法
            List<User> userList = sqlSession.selectList("com.feng.dao.UserDao.getUserList");
            for (User user : userList) {
                System.out.println(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //3.关闭sqlSession
            sqlSession.close();
        }
    }

    @Test
    public void getUserById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User user = mapper.getUserById(1);
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void getUserById2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name","冯冯");
        User user = mapper.getUserById2(map);
        System.out.println(user);
        sqlSession.close();
    }

    //增删改需要提交事务
    @Test
    public void addUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        int res = mapper.addUser(new User(4, "王五", "123456"));
        if (res > 0) {
            System.out.println("插入成功！");
            //提交事务
            sqlSession.commit();
        }
        getUserList();
        sqlSession.close();
    }

    @Test
    public void addUser2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userid",4);
        map.put("username","Hello");
        map.put("password","123456");
        mapper.addUser2(map);
        sqlSession.commit();
        getUserList();
        sqlSession.close();
    }

    @Test
    public void updateUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        int res = mapper.updateUser(new User(1, "冯冯", "123123"));
        if (res > 0) {
            System.out.println("更新成功！");
            //提交事务
            sqlSession.commit();
        }
        getUserList();
        sqlSession.close();
    }

    @Test
    public void deleteUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        int res = mapper.deleteUser(4);
        if (res > 0){
            System.out.println("删除成功！");
            //提交事务
            sqlSession.commit();
        }
        getUserList();
        sqlSession.close();
    }
}

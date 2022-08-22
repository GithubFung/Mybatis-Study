package com.feng.dao;

import com.feng.pojo.User;
import com.feng.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * Created by 小冯 on 2022/8/23 0:26
 */
public class UserDaoTest {
    @Test
    public void test() {
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
}

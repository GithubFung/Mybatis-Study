package feng.dao;


import feng.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by 小冯 on 2022/8/23 0:13
 */
public interface UserDao {

    //1、注解在接口实现
    @Select("select * from user")
    List<User> getUsers();

    @Select("select * from user where id = #{id}")
    User getUserById(@Param("id") int id);//方法存在多个（基本类型/String）参数时，每个参数前一定要加上@Param

    @Insert("insert into user (id,name,pwd) values (#{id},#{name},#{password})")
    int addUser(User user);

    @Update("update user set name = #{name}, pwd = #{password} where id = #{id}")
    int updateUser(User user);

    @Delete("delete from user where id = #{id}")
    int deleteUser(int id);
}

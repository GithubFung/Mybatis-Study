package feng.dao;

import feng.pojo.Student;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by 小冯 on 2022/9/7 21:05
 */
public interface StudentMapper {
    //查询所有的学生的信息以及对应的老师的信息
    public List<Student> getStudent();
}

import feng.dao.StudentMapper;
import feng.dao.TeacherMapper;
import feng.pojo.Student;
import feng.pojo.Teacher;
import feng.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * Created by 小冯 on 2022/9/7 21:13
 */
public class MyTest {
    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacher(1);
        System.out.println(teacher);
        sqlSession.close();
    }
    @Test
    public void testStudent(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> student = mapper.getStudent();
        for (Student student1 : student) {
            System.out.println(student1);
        }
        sqlSession.close();
    }
}

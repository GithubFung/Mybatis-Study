import feng.dao.TeacherMapper;
import feng.pojo.Teacher;
import feng.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

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
}

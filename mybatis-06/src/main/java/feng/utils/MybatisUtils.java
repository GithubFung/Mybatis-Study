package feng.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by 小冯 on 2022/8/22 23:56
 */
//sqlSessionFactory --> sqlSession
public class MybatisUtils {
    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            //获取sqlSessionFactory对象
            String resource = "mybatis-config.xml";
            //1、Resources获取加载全局配置文件
            InputStream inputStream = Resources.getResourceAsStream(resource);
            //2、实列化SqlSessionFactoryBuilder构造器（解析配置文件流XMLConfigBuilder、Configuration所有的配置信息）
            //实例化sqlSessionFactory
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //获取sqlSession实列
    public static SqlSession getSqlSession() {
        //true 自动提交事务 不需要手动sqlSession.commit()
        return sqlSessionFactory.openSession(true);
    }
}

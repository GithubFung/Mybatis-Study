package feng.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

/**
 * Created by 小冯 on 2022/8/23 0:06
 */
//实体类
//别名方法二
@Alias("User")
//lombok插件，自动生成get set toString等
// 不支持多种参数构造器的重载，不建议使用
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;
    private String name;
    private String password;
}

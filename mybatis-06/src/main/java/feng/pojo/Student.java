package feng.pojo;

import lombok.Data;

/**
 * Created by 小冯 on 2022/9/7 20:58
 */
@Data
public class Student {
    private int id;
    private String name;

    //学生需要关联一个老师
    private Teacher teacher;
}

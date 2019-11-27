package com.shanshuan.user.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by wangzifeng on 2019/11/20.
 */
@Table(name = "tb_user")
@Data
public class User {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;//主键
    private String userName;//用户名
    private String password;//密码
    private String name;//姓名
    private Integer age;//年龄
    private Integer sex;//性别 ，1 男；2女
    private Date birthday;//出生日期
    private Date created;//创建时间
    private Date updated;//更新时间
    private String note;//备注

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", birthday=" + birthday +
                ", created=" + created +
                ", updated=" + updated +
                ", note='" + note + '\'' +
                '}';
    }
}

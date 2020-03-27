package com.java.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.java.enums.GradeEnum;
import com.java.enums.SexEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author huangzhen
 * @create 2020-03-23 21:50
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
//@TableName(value = "tb_user")
public class User  extends Model<User> {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private String userName;
    private String password;
    private String name;
    private Integer age;
    @TableField(value = "email",fill = FieldFill.INSERT)
    private String mail;

    @Version //乐观锁机制
    @TableField(fill = FieldFill.INSERT) //插入时，若为null，则自动填充
    private Integer version;

    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private Integer deleted;

    private SexEnum sex;
    private GradeEnum grade;


}

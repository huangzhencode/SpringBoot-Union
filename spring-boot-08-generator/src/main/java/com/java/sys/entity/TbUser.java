package com.java.sys.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author hz
 * @since 2020-03-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TbUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 版本
     */
    private Integer version;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 未删除为0，已删除为1
     */
    private Integer deleted;

    private Integer grade;

    /**
     * 0-女  1-男
     */
    private Integer sex;


}

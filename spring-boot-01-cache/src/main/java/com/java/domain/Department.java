package com.java.domain;

import java.io.Serializable;

/**
 * @author huangzhen
 * @create 2020-03-20 21:06
 */
public class Department implements Serializable {
    private Integer id;
    private String departmentName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}

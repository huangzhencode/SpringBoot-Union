package com.java.controller;

import com.java.domain.Department;
import com.java.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huangzhen
 * @create 2020-03-20 21:09
 */
@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/dept/{id}")
    public Department findDeptById(@PathVariable("id") Integer id){
        return departmentService.findDeptById(id);
    }

}




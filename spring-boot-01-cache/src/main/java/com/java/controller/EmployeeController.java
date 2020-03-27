package com.java.controller;

import com.java.domain.Employee;
import com.java.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huangzhen
 * @create 2020-03-20 15:16
 */
@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/emp/{id}")
    public Employee findEmpById(@PathVariable("id") Integer id) {
        return employeeService.findEmpById(id);
    }

    @GetMapping("/emp")
    public Employee updateEmp(Employee employee) {
        return employeeService.updateEmp(employee);
    }

    @GetMapping("/delEmp/{id}")
    public String deleteEmpById(@PathVariable("id") Integer id) {
        employeeService.deleteEmp(id);
        return "success";
    }
    @GetMapping("/findEmp/{lastName}")
    public Employee findEmpByLastName(@PathVariable("lastName") String lastName) {
       return employeeService.findEmpByLastName(lastName);
    }
}

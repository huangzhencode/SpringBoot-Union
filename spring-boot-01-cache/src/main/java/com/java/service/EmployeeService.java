package com.java.service;

import com.java.domain.Employee;
import com.java.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

/**
 * @author huangzhen
 * @create 2020-03-20 15:16
 */
@Service
@CacheConfig(cacheNames = "emp")
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    @Cacheable(condition = "#id>1",unless = "#id>=4")
    public Employee findEmpById(Integer id){
        System.out.println("查询" + id + "号Employee");
        return employeeMapper.findEmpByid(id);
    }

    @CachePut(key = "#result.id")
    public Employee updateEmp(Employee employee){
        employeeMapper.updateEmp(employee);
        return employee;
    }

    @CacheEvict(key = "#id",beforeInvocation = true)
    public void deleteEmp(Integer id){
        System.out.println("delete OK");
        employeeMapper.deleteEmp(id);
    }

    @Caching(
            put={
                    @CachePut(key = "#result.id"),
                    @CachePut(key = "#result.lastName")
            }
    )
    public Employee findEmpByLastName(String lastName){
        return employeeMapper.findEmpByLastName(lastName);
    }
}

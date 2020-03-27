package com.java.service;

import com.java.domain.Department;
import com.java.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author huangzhen
 * @create 2020-03-20 21:08
 */
@Service
@CacheConfig(cacheNames = "dept")
public class DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;


    @Cacheable(key = "#id")
    public Department findDeptById(Integer id){
        return departmentMapper.findDeptById(id);
    }
}

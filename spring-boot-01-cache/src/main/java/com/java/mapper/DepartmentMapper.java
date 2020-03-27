package com.java.mapper;

import com.java.domain.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author huangzhen
 * @create 2020-03-20 21:07
 */
@Mapper
@Repository
public interface DepartmentMapper {

    @Select("select * from department where id = #{id}")
    Department findDeptById(Integer id);
}

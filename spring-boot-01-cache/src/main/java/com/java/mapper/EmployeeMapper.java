package com.java.mapper;

import com.java.domain.Employee;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * @author huangzhen
 * @create 2020-03-20 15:16
 */
@Mapper
@Repository
public interface EmployeeMapper {

    @Select("select * from employee where id = #{id}")
    Employee findEmpByid(Integer id);

    @Update("update employee set lastName=#{lastName},email=#{email},gender=#{gender},d_id=#{dId} where id=#{id}")
    void updateEmp(Employee employee);

    @Delete("delete from employee where id = #{id}")
    void deleteEmp(Integer id);

    @Select("select * from employee where lastName = #{lastName}")
    Employee findEmpByLastName(String lastName);
}

package com.java.mapper;

import com.java.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author huangzhen
 * @create 2020-03-23 21:58
 */
@Repository
@Mapper
public interface UserMapper extends MyBaseMapper<User> {
    User findUserById(Integer id);

    List<User> findUserAll();
}

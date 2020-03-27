package com.java.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @author huangzhen
 * @create 2020-03-24 22:16
 */
public interface MyBaseMapper<T> extends BaseMapper<T> {
    List<T> findAll();
}

package com.java.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

/**
 *
 * 自动注入
 * @author huangzhen
 * @create 2020-03-24 22:44
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        Object mail = getFieldValByName("mail", metaObject);
        setFieldValByName("version", 1, metaObject);
        setFieldValByName("deleted", 0, metaObject);
        if (mail == null){
            setFieldValByName("mail", "admin#qq", metaObject);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {

    }
}

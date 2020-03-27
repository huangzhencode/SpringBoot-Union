package com.java.enums;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.baomidou.mybatisplus.core.enums.IEnum;

public enum SexEnum implements IEnum<Integer> {

    MAN(1, "男"),
    WOMAN(0, "女");

    //序列化枚举值为数据库存储值
    @JSONField(serialzeFeatures= SerializerFeature.WriteEnumUsingToString)
    private int value;
    private String descp;

    SexEnum(int value, String descp) {
        this.value = value;
        this.descp = descp;
    }

    @Override
    public Integer getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return this.descp;
    }
}

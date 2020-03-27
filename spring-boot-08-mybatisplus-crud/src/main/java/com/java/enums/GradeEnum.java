package com.java.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

public enum  GradeEnum {
    PRIMARY(1, "小学"),
    SECONDORY(2, "中学"),
    HIGH(3, "高中");

    @EnumValue//标记数据库存储的值
    @JsonValue    //序列化枚举值为数据库存储值
    private final int code;
    private final String descp;

    GradeEnum(int code, String descp) {
        this.code = code;
        this.descp = descp;
    }

    @Override
    public String toString() {
        return this.descp;
    }
}

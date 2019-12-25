package com.lee.birthnotice.enums;

/**
 *
 * 日历类型枚举
 * @author lee5488
 * @version 1.0 2019/12/25
 */
public enum CalendarTypeEnum {
    NEW(1,"新历"),
    OLD(2,"农历"),

    ;


    private Integer type;
    private String name;


    CalendarTypeEnum(Integer type, String name) {
        this.type = type;
        this.name = name;
    }


    public Integer getType() {
        return type;
    }

    public String getName() {
        return name;
    }

}

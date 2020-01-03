package com.lee.birthnotice.enums;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lee5488
 * @version 1.0 2020/1/3
 */
public enum Weather {
    SUNNY(1,"晴"),
    RAIN(2,"雨"),
    CLOUDY(3,"阴"),
    SNOW(4,"雪"),
    ;

    private Integer type;
    private String name;

    Weather(Integer type, String name) {
        this.type = type;
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public static boolean contains(String name){
        for (Weather value : Weather.values()) {
            if (value.getName().equals(name)){
                return true;
            }
        }
        return false;
    }

    public static String contactName(){
        List<String> nameList = new ArrayList<>(Weather.values().length);
        for (Weather value : Weather.values()) {
            nameList.add(value.getName());
        }
        return nameList.stream().collect(Collectors.joining(",","(",")"));
    }
}

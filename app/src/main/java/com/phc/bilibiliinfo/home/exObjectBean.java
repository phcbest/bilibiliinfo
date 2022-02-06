package com.phc.bilibiliinfo.home;

import java.io.Serializable;

public class exObjectBean implements Serializable {

    //用于序列化和反序列化
    private static final long serialVersionUID = -7620435178023928252L;
    private String name;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}

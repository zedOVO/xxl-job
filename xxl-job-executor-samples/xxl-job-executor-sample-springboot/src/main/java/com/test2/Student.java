package com.test2;

public class Student extends Person {
    public int age = 20;
    public String name = "student";

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void sayMyInfo() {
        System.out.println("我是"+this.name+","+"年龄:"+this.age+".");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}

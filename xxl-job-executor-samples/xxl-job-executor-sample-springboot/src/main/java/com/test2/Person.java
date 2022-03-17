package com.test2;

public abstract class Person {
    private String name="person";
    private int age = 40;

    public abstract void sayMyInfo();

    public void doSomething(){
        System.out.println("我是"+this.name+","+"年龄:"+this.age+".");
    }

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

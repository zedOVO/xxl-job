package com.test;

public class Person {

    public Person(){};
    public Person(int age,String name,String birthday,int sex){
        this.age = age;
        this.name = name;
        this.birthday = birthday;
        this.sex = sex;
    };
    public int age;
    public String name;
    public String birthday;
    public int sex;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String  birthday) {
        this.birthday = birthday;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }
}

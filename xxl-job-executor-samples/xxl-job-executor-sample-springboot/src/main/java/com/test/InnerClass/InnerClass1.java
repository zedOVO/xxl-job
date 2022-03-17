package com.test.InnerClass;

import java.text.SimpleDateFormat;
import java.util.Date;

public class InnerClass1 {



    private static InnerClass1.innerClass innerClass;



    public class innerClass{

    }

    public String name;
    public String age;
    public String createTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}

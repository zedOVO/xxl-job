package com.Utils;

import java.util.UUID;

public class PublicVoids {


    public String getUUID(){
        return UUID.randomUUID().toString().trim().replaceAll("-","");
    }
}

package com.test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {
//        Hashtable hashTable = new Hashtable<>();
//        hashTable.put(null,"1");
//        System.out.println(hashTable.toString());

        Map hashMap = new HashMap<>();
        hashMap.put(null,"1");
        System.out.println(hashMap.get(null));
    }
}

package com.sunflower.redisDem;

import redis.clients.jedis.Jedis;

import java.util.HashMap;

public class JedisGen {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");
        HashMap<String, String> map = new HashMap();
        map.put("key1","value1");
        map.put("key2","value2");
        map.put("key3","value3");
        for (String key : map.keySet()){
            jedis.hset("map",key,map.get(key));
        }
        jedis.close();
    }
}

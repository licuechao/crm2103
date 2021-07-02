package com.bjpowernode;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App2
{
    public static void main( String[] args )
    {
        JedisPool pool=null;
        try {
            pool = RedisUtils.open("127.0.0.1",6379);
            Jedis jedis = pool.getResource();
           jedis.flushAll();
           jedis.hset("website","taobao","www.taobao.com");
           String str1 = jedis.hget("website", "taobao");
            System.out.println(str1);
           Map<String,String>map = new HashMap<>();
           map.put("id","001");
           map.put("name","jerry");
           map.put("age","11");
           jedis.hmset("student",map);
            List<String> slist = jedis.hmget("student", "id", "name", "age");
            for (String str : slist) {
                System.out.println(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            RedisUtils.close();
        }
    }
}

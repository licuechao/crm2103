package com.bjpowernode;

import redis.clients.jedis.Jedis;

public class App 
{
    public static void main( String[] args )
    {
		//我是注释
        Jedis jedis = new Jedis("127.0.0.1",6379);
        jedis.flushAll();//清空redis中数据
        jedis.set("username","tom");
        String username = jedis.get("username");
        System.out.println(username);


    }
}

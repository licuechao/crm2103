package com.bjpowernode;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisUtils {
    //定义连接池对象
    private  static  JedisPool pool = null;
    public static  JedisPool open(String host,int port){
        if (pool==null){
            JedisPoolConfig config =new JedisPoolConfig();
            //默认最大连接数
            config.setMaxTotal(10);
            //空闲连接数
            config.setMaxIdle(2);
            config.setTestOnBorrow(true);
            pool = new JedisPool(config,host,port);
        }
        return pool;
    }
    public static void close(){
        if (pool!=null){
            pool.close();
        }
    }
}

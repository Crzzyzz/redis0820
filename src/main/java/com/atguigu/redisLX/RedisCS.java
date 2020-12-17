package com.atguigu.redisLX;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;

import java.util.Set;
public class RedisCS{
    public static void main (String[] args){
//        Jedis jedis=new Jedis("linux3", 6379);
//        String ping=jedis.ping();
//        System.out.println("连接成功:" + ping); //连接成功:PONG

//        Jedis jedis=RedisSentinel.getJedisFromSentinelPool();
//        Set<String> keys=jedis.keys("*");
//        for(String key : keys){
//            System.out.println(key);
//            //k3
//            //k4
//            //k1
//            //k2
//        }

        JedisCluster jedis = RedisCluster.getJedisCluster();
        jedis.set("k1000","v1000");
        System.out.println(jedis.get("k1000")); //v1000
        //不要关闭,这个给一个连接池


//        jedis.close();
    }
}

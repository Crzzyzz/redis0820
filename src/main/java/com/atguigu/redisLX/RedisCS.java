package com.atguigu.redisLX;
import redis.clients.jedis.Jedis;
import java.util.Set;
public class RedisCS{
    public static void main (String[] args){
//        Jedis jedis=new Jedis("linux3", 6379);
//        String ping=jedis.ping();
//        System.out.println("连接成功:" + ping); //连接成功:PONG
        Jedis jedis=RedisSentinel.getJedisFromSentinelPool();
        Set<String> keys=jedis.keys("*");
        for(String key : keys){
            System.out.println(key);
            //k3
            //k4
            //k1
            //k2
        }
        jedis.close();
    }
}

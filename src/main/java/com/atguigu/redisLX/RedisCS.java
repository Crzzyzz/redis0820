package com.atguigu.redisLX;
import redis.clients.jedis.Jedis;
public class RedisCS{
    public static void main (String[] args){
        Jedis jedis=new Jedis("linux3", 6379);
        String ping=jedis.ping();
        System.out.println("连接成功:" + ping); //连接成功:PONG
        jedis.close();
    }
}

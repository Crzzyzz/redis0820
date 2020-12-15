package com.atguigu.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.util.Set;

public class RedisTest {


    public static void main(String[] args) {

        Jedis jedis =  RedisUtil.getJedisFromPool();

        Set<String> keys = jedis.keys("*");

        for (String key : keys) {
            System.out.println(key);
        }

        Set<Tuple> z1 = jedis.zrevrangeWithScores("z1", 0, -1);

        for (Tuple tuple : z1) {
            System.out.println(tuple.getElement() + ":" + tuple.getScore());
        }


        //如果是连接池的连接  会自动还会连接池
        jedis.close();



    }
}

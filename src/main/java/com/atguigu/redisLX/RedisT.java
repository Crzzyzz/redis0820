package com.atguigu.redisLX;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.util.Set;
public class RedisT{
    public static void main (String[] args){

        Jedis jedis=RedisPool.getJedisFromPool();

        Set<String> keys=jedis.keys("*");
        for(String key : keys){
            System.out.println(key);
        }

        System.out.println(jedis.zrange("z1", 0, -1));  //[v3, v2, v1]
        Set<Tuple> z1=jedis.zrangeWithScores("z1", 0, -1);
        System.out.println(z1); //[[v3,70.0], [v2,90.0], [v1,100.0]]
        for(Tuple tuple : z1){
            System.out.println(tuple);
            //[v3,70.0]
            //[v2,90.0]
            //[v1,100.0]
        }
        for(Tuple tuple : z1){
            System.out.println(tuple.getElement()+"---"+tuple.getScore());
            //tuple是Redis制作的,有两个值getElement普通值,getScore分数
            //v3---70.0
            //v2---90.0
            //v1---100.0
        }
        //如果是连接池的连接,会自动换回连接池
        jedis.close();
    }
}

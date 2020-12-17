package com.atguigu.redisLX;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisSentinelPool;
import java.util.HashSet;
import java.util.Set;
public class RedisSentinel{
    private static JedisSentinelPool jedisSentinelPool=null;  //定义一个连接池

    public static Jedis getJedisFromSentinelPool (){ //获取连接
        if (jedisSentinelPool == null) {  //如果连接池不存在创建连接池
            JedisPoolConfig jedisPoolConfig=new JedisPoolConfig();
            jedisPoolConfig.setMaxTotal(10);    //最大可用连接数
            jedisPoolConfig.setMaxIdle(5);  //最大闲置连接数
            jedisPoolConfig.setMinIdle(2);  //最小闲置连接数
            jedisPoolConfig.setBlockWhenExhausted(true);    //连接耗尽是否等待
            jedisPoolConfig.setMaxWaitMillis(2000); //等待时间2s
            jedisPoolConfig.setTestOnBorrow(true);  //取连接的时候进行测试ping pong

            Set<String> sentinelSet=new HashSet<>();  //设置哨兵配置集合
            sentinelSet.add("192.168.65.163:26379");    //加入哨兵地址
            jedisSentinelPool=new JedisSentinelPool("mymaster", sentinelSet, jedisPoolConfig);   //创建连接池

            return jedisSentinelPool.getResource(); //得到连接
        } else {
            return jedisSentinelPool.getResource();
        }
    }
}

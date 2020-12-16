package com.atguigu.redisLX;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
public class RedisPool{
    private static JedisPool jedisPool = null;  //定义一个连接池
    public static Jedis getJedisFromPool(){ //获取连接
        if(jedisPool == null){  //如果连接池不存在创建连接池
            JedisPoolConfig jedisPoolConfig=new JedisPoolConfig();
            jedisPoolConfig.setMaxTotal(10);    //最大可用连接数
            jedisPoolConfig.setMaxIdle(5);  //最大闲置连接数
            jedisPoolConfig.setMinIdle(2);  //最小闲置连接数
            jedisPoolConfig.setBlockWhenExhausted(true);    //连接耗尽是否等待
            jedisPoolConfig.setMaxWaitMillis(2000); //等待时间2s
            jedisPoolConfig.setTestOnBorrow(true);  //取连接的时候进行测试ping pong
            jedisPool = new JedisPool(jedisPoolConfig,"192.168.65.163",6379);   //创建连接池

            return jedisPool.getResource(); //得到连接
        } else {
            return jedisPool.getResource();
        }
    }
}

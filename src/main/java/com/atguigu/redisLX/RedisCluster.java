package com.atguigu.redisLX;

import redis.clients.jedis.*;

import java.util.HashSet;
import java.util.Set;

public class RedisCluster{
    private static JedisCluster jedisCluster=null;  //定义一个连接池

    public static JedisCluster getJedisCluster (){ //获取连接
        if (jedisCluster == null) {  //如果连接池不存在创建连接池
            JedisPoolConfig jedisPoolConfig=new JedisPoolConfig();
            jedisPoolConfig.setMaxTotal(10);    //最大可用连接数
            jedisPoolConfig.setMaxIdle(5);  //最大闲置连接数
            jedisPoolConfig.setMinIdle(2);  //最小闲置连接数
            jedisPoolConfig.setBlockWhenExhausted(true);    //连接耗尽是否等待
            jedisPoolConfig.setMaxWaitMillis(2000); //等待时间2s
            jedisPoolConfig.setTestOnBorrow(true);  //取连接的时候进行测试ping pong

            Set<HostAndPort> nodesSet =new HashSet<>();  //设置节点集合
            nodesSet.add(new HostAndPort("192.168.65.163",6379));
            nodesSet.add(new HostAndPort("192.168.65.163",6380));
            nodesSet.add(new HostAndPort("192.168.65.163",6381));
            nodesSet.add(new HostAndPort("192.168.65.163",6389));
            nodesSet.add(new HostAndPort("192.168.65.163",6390));
            nodesSet.add(new HostAndPort("192.168.65.163",6391));

            jedisCluster = new JedisCluster(nodesSet,jedisPoolConfig);
            return jedisCluster; //得到连接
        } else {
            return jedisCluster;
        }
    }
}

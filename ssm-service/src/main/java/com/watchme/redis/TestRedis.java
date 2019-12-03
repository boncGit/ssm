package com.watchme.redis;

import redis.clients.jedis.Jedis;

public class TestRedis {

    private Jedis jedis;

    /**
     * 连接redis服务器
     */
    public void connectRedis() {
        jedis=RedisUtil.getJedis();
    }

    /**
     * redis操作字符串
     */
    public void testString() {
        jedis.set("name", "mengxy-asiainfo");
//        //添加数据
//        jedis.set("name", "youcong");
//        System.out.println(jedis.get("name"));
//
//        //拼接字符串
//        jedis.append("name", ".com");
//        System.out.println(jedis.get("name"));

//        //删除数据
//        jedis.del("name");
//        System.out.println(jedis.get("name"));

        //设置多个键值对
//        jedis.mset("name","yc","age","22","qq","1933108196");
//        jedis.incr("age");//加1操作

//        System.out.println(jedis.get("name") + "-" + jedis.get("age") + "-" +jedis.get("qq"));
    }

    public static void main(String[] args){
        TestRedis test = new TestRedis();
        test.connectRedis();
        test.testString();
    }
}

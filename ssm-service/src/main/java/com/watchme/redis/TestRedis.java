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
        try{
        //添加数据
        jedis.set("name", "youcong");
        System.out.println(jedis.get("name"));

        //拼接字符串
        jedis.append("name", ".com");
        System.out.println(jedis.get("name"));

        //删除数据
        jedis.del("name");
        System.out.println(jedis.get("name"));

        //设置多个键值对
        jedis.mset("name","yc","age","22","qq","1933108196");
        jedis.incr("age");//加1操作

        System.out.println(jedis.get("name") + "-" + jedis.get("age") + "-" +jedis.get("qq"));

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            RedisUtil.returnResource(jedis);
        }
    }

    public void set(String key, String value) {

        try{
            jedis.set(key,value);
        }catch(Exception e){
            if(jedis != null){
                RedisUtil.returnResource(jedis);
            }
        }finally {
            if(jedis != null){
                RedisUtil.returnResource(jedis);
            }
        }
    }

    public Long expire(String key,int seconds){
        Long time = null;
        try{
            time = jedis.expire(key,seconds);
        }catch(Exception e){
           if(jedis != null){
               RedisUtil.returnResource(jedis);
           }
           return null;
        }finally {
            if(jedis != null){
                RedisUtil.returnResource(jedis);
            }
        }
        return time;
    }

    public static void main(String[] args){
        TestRedis test = new TestRedis();
        test.connectRedis();
//        test.set("token","12345678");
        Long time = null;
        time = test.expire("token",10);
        System.out.println(time);
    }
}

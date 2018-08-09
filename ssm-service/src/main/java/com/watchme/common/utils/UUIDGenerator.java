package com.watchme.common.utils;

/**
 * Created by wangqiang on 2017/6/2.
 */
public class UUIDGenerator {
    public UUIDGenerator() {
    }

    /**
     * 获得一个UUID
     *
     * @return String UUID
     */
    public synchronized static String getUUID() {
        SnowflakeIdWorker id = new SnowflakeIdWorker();
        return id.nextId() + "";
    }


    public static void main(String[] args) {
        SnowflakeIdWorker idWorker = new SnowflakeIdWorker(31, 31);
        System.out.println("idWorker=" + idWorker.nextId());
        SnowflakeIdWorker id = new SnowflakeIdWorker();
        System.out.println("id=" + id.nextId());
        System.out.println("id=" + UUIDGenerator.getUUID());
    }
}

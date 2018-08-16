package com.watchme.common.utils.thread;

/**
 * Created by Mengxy on 2018/8/16.
 */
public class TestThreadLocal {
    // 定义匿名子类创建ThreadLocal的变量
    private static ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>() {
        // 覆盖初始化方法
        public Integer initialValue() {
            return 0;
        }
    };
    // 下一个序列号
    public static int getNextNum() {
        seqNum.set(seqNum.get() + 1);
        return seqNum.get();
    }
}

package com.watchme.common.utils.thread;

/**
 * Created by Mengxy on 2018/8/16.
 */
public class TestThread extends Thread{

    public TestThread(String name) {
        super(name);
    }

    @Override
    public void run(){
        for (int i = 0; i < 3; i++) {
            System.out.println("thread[" + Thread.currentThread().getName()   + "] sn[" + TestThreadLocal.getNextNum() + "]");
        }
    }

    public static void main(String[] args){

        TestThread thread1 = new TestThread("thread1");
        TestThread thread2 = new TestThread("thread2");
        thread1.start();
        thread2.start();
    }
}

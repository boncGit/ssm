package com.watchme.common.utils.thread;

/**
 * Created by Mengxy on 2018/6/19.
 */
public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("MyRunnable running");
    }


    public static void main(String[] args){
        MyRunnable runnable = new MyRunnable();
        Thread thread = new Thread(runnable,"MyRunnable1");
        thread.start();
        System.out.println(thread.getName());
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName);
    }
}

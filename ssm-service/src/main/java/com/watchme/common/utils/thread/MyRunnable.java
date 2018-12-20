package com.watchme.common.utils.thread;

import static java.lang.Thread.sleep;

/**
 * Created by Mengxy on 2018/6/19.
 */
public class MyRunnable implements Runnable{
    private int count=15;

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + "运行  count= " + count--);
            try {
//                sleep((int) Math.random() * 10);
                sleep((int) 2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args){
        MyRunnable runnable = new MyRunnable();
        Thread thread = new Thread(runnable,"MyRunnable1");
        thread.start();
        System.out.println(thread.getName());
        System.out.println(Thread.currentThread().getName());
    }

}

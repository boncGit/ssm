package com.watchme.common.utils.thread;

/**
 * Created by Mengxy on 2018/6/19.
 */
public class MyThread extends Thread{

    @Override
    public void run(){
        System.out.println("MyThread running");
    }


    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
    }

}

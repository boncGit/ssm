package com.watchme.common.utils.thread;

/**
 * Created by Mengxy on 2018/6/19.
 */
public class MyThread extends Thread{

    private int count=5;
    private String name;
    public MyThread(String name) {
        this.name=name;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(name + "运行  count= " + count--);
            try {
//                sleep((int) Math.random() * 10);
                sleep((int) 2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        MyThread myThreadA = new MyThread("A");
        MyThread myThreadB = new MyThread("B");
        myThreadA.start();
        myThreadB.start();
    }

}

package com.watchme.common.utils.thread;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Mengxy on 2018/6/19.
 */
public class Queue {

    public static void main(String[] args){
        testQueue();

    }

    public static void testThread(){
        Thread thread = new Thread();
        thread.start();
    }


    public static void testQueue(){
        LinkedBlockingQueue<Integer> linkedBlockingQueue = new LinkedBlockingQueue();

        try {
            for(int i=0;i<10;i++){
                linkedBlockingQueue.put(i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(linkedBlockingQueue);

        try {
            while(true){
                int a = linkedBlockingQueue.take();
                System.out.println(a);
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

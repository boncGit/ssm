package com.watchme.common.utils.thread.threadPool;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.Thread.sleep;

public class MyNewCachedThreadPool {

    private static ExecutorService executorService = Executors.newCachedThreadPool();
    private static List<String> list = new ArrayList<String>();

    /**
     * 保存
     */
    public static void save(){
        long start = System.currentTimeMillis();
        try{

//            run("mengxy");
//            run("wangqiang");
//            run("suzg");

            SaveThread SaveThread1 = new SaveThread("mengxy");
            SaveThread SaveThread2 = new SaveThread("wangqiang");
            SaveThread SaveThread3 = new SaveThread("suzg");
            executorService.execute(SaveThread1);
            executorService.execute(SaveThread2);
            executorService.execute(SaveThread3);

         }catch (Exception e){
            e.printStackTrace();
        }finally {
            long end = System.currentTimeMillis();
            System.out.println("耗时"+(end-start));
            executorService.shutdown();
        }
    }

    /**
     * 保存线程
     */
    public static class SaveThread extends Thread {

        private String name;
        public SaveThread(String name) {
            this.name=name;
        }

        @Override
        public void run() {
            try{
                for(int i=0;i<10;i++){
                    sleep( 1000);
                    System.out.println(name+i);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void run(String name) {
        try{
            for(int i=0;i<10;i++){
                sleep( 2000);
                System.out.println(name+i);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

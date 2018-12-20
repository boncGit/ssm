package com.watchme.common.utils.thread.threadPool;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyNewCachedThreadPool {

    private static ExecutorService executorService = Executors.newCachedThreadPool();
    private static List<String> list = new ArrayList<String>();

    /**
     * 保存
     */
    public static void save(){
        try{
            SaveThread SaveThread1 = new SaveThread("mengxy");
            SaveThread SaveThread2 = new SaveThread("wangqiang");
            SaveThread SaveThread3 = new SaveThread("suzg");
            executorService.submit(SaveThread1);
            executorService.submit(SaveThread2);
            executorService.submit(SaveThread3);
            System.out.println(list);
         }catch (Exception e){
            e.printStackTrace();
        }finally {
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
                    sleep( 2000);
                    System.out.println(name+i);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}

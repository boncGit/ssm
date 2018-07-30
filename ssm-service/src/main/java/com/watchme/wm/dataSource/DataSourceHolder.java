package com.watchme.wm.dataSource;

/**
 * Created by huangpeng on 2016/1/6.
 */
public class DataSourceHolder {
    //线程本地环境
    private static final ThreadLocal<String> dataSources = new ThreadLocal<String>();
    //设置数据源
    public static void setDataSource(String customerType) {
        dataSources.set(customerType);
//        System.out.println(Thread.currentThread().getName()+"@@@@@@@@@@@@@@set dataSource:"+dataSources.get());
    }
    //获取数据源
    public static String getDataSource() {
//        System.out.println(Thread.currentThread().getName()+"@@@@@@@@@@@@@@1dataSource:"+dataSources.get());
        return (String) dataSources.get();
    }
    //清除数据源
    public static void clearDataSource() {
        dataSources.remove();
    }
}

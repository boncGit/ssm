package com.watchme.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;
import org.apache.commons.lang3.StringUtils;

public class ReadTxtData {

    public static void main(String[] args) {
        String path = "/home/lyf/apps/test/info";
        String host = "192.168.1.106";
        int port = 22;
        String username = "root";
        String password = "123456";
        String type = "grid";
        readTxt(host,port,username,password,path,type);
    }


    public static void readTxt(String host,int port,String username,String password,String path,String type){
        Connection ss = getConnect(host, port, username, password);//获取连接
        if (fileExist(path, ss)) {//判断文件是否存在
            readLogFile(path, ss,type);//读取文件
        }
    }

    //获取连接
    public static Connection getConnect(String hostName, int port,String username, String password) {
        Connection conn = new Connection(hostName, port);
        try {
            // 连接到主机
            conn.connect();
            // 使用用户名和密码校验
            boolean isconn = conn.authenticateWithPassword(username, password);
            if (!isconn) {
                System.out.println("用户名称或者是密码不正确");
            } else {
                System.out.println("服务器连接成功.");
                return conn;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //判断文件是否存在
    public static boolean fileExist(String path, Connection conn) {
        if (conn != null) {
            Session ss = null;
            try {
                ss = conn.openSession();
                ss.execCommand("ls -l ".concat(path));
                InputStream is = new StreamGobbler(ss.getStdout());
                BufferedReader brs = new BufferedReader(new InputStreamReader(is));
                String line = "";
                while (true) {
                    String lineInfo = brs.readLine();
                    ;
                    if (lineInfo != null) {
                        line = line + lineInfo;
                    } else {
                        break;
                    }
                }
                brs.close();
                if (line != null && line.length() > 0 && line.startsWith("-")) {
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                // 连接的Session和Connection对象都需要关闭
                if (ss != null) {
                    ss.close();
                }
            }
        }
        return false;
    }

    //读取文件
    public static void readLogFile(String path, Connection conn,String type) {
        if (conn != null) {
            Session ss = null;
            try {
                ss = conn.openSession();
                ss.execCommand("tail -10000 ".concat(path));
                InputStream is = new StreamGobbler(ss.getStdout());
                BufferedReader brs = new BufferedReader(new InputStreamReader(is));
                while (true) {
                    String line = brs.readLine();
                    if (StringUtils.isEmpty(line)) {
                        break;
                    } else {
                        saveDate(line,type);//解析保存数据
                        System.out.println(line);
                    }
                }
                brs.close();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                // 连接的Session和Connection对象都需要关闭
                if (ss != null) {
                    ss.close();
                }
                if (conn != null) {
                    conn.close();
                }
            }
        }
    }

    //根据文件格式解析文件
    private static void saveDate(String line,String type){
        if(StringUtils.isNotBlank(type)){
            if("grid".equals(type)){//网格数据
                String[] strs = line.split("|");
                if(strs != null && strs.length>0 ){
                    String cityCode = strs[0];//地址编码
                    String cityName = strs[1];//地市名称
                    String countyCode = strs[2];//区县编码
                    String countyName = strs[3];//区县名称
                    String gridCode = strs[4];//网格编码
                    String gridName = strs[5];//网格名称
                    String bossNum = strs[6];//bosss工号
                    String channelCodes = strs[7];//渠道编码（用，隔开）
                    //保存网格表
                    // save tf_grid

                    //渠道编码
                    if(StringUtils.isNotBlank(channelCodes)){
                        String[] codes = channelCodes.split(",");
                        if(codes != null && codes.length>0){
                            for(String code :codes){
                                //保存网格渠道关系表
                                //save tf_grid_channel
                            }
                        }
                    }
                }
            }else if("channel".equals(type)){//渠道数据
                String[] strs = line.split("|");
                if(strs != null && strs.length>0 ){
                    String channelCode = strs[0];//渠道编码
                    String channelName = strs[1];//渠道名称
                    String address = strs[2];//地址
                    String contact = strs[3];//联系人
                    String cityCode = strs[4];//地址编码
                    String cityName = strs[5];//地市名称
                    String countyCode = strs[6];//区县编码
                    String countyName = strs[7];//区县名称
                    String longitude = strs[8];//经度
                    String latitude = strs[9];//纬度
                    String channelStartType = strs[10];//渠道星级
                    String channelTypeCode = strs[11];//渠道类型编码
                    String channelTypeName = strs[12];//渠道类型名称
                    String channelFlag = strs[13];//标识

                    //保存渠道
                    //save tf_f_ec_org
                }
            }
        }
    }
}

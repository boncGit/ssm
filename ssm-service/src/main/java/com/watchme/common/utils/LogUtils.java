/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.watchme.common.utils;


import com.watchme.system.user.entity.TbUser;
import org.aspectj.lang.JoinPoint;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * 字典工具类
 *
 * @author ThinkGem
 * @version 2014-11-7
 */
public class LogUtils {

    public static final String CACHE_MENU_NAME_PATH_MAP = "menuNamePathMap";

    private static ExecutorService executorService = Executors.newCachedThreadPool();
    private static String systemUrl = "DS-SYSTEM-PROVIDER";


    /**
     * 保存日志
     */
    public static void saveLog(HttpServletRequest request, String title) {
        saveLog(request, null, null);
    }

    /**
     * 保存日志
     */
    public static void saveLog(HttpServletRequest request, JoinPoint joinPoint, String ex) {
        TbUser user = new TbUser();
//        User user = SessionUtil.getObject(request, "user");
        if (user != null) {
            Map log = new HashMap();
            String id = UUID.randomUUID().toString().replaceAll("-", "");
            String type = ex == "" ? "1" : "2";
            String url = request.getRequestURL().toString();
            String method = request.getMethod();
            String classMethod = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
            String ip = request.getRemoteAddr();
            String userAgent = request.getHeader("user-agent");
            String parms = Arrays.toString(joinPoint.getArgs());
            String e = ex;
//            log.put("userId", user.getId());
//            log.put("userName", user.getUserName());
            log.put("id", id);
            log.put("type", type);
            log.put("url", url);
            log.put("method", method);
            log.put("classMethod", classMethod);
            log.put("ip", ip);
            log.put("userAgent", userAgent);
            log.put("parms", parms);
            log.put("ex", e);

//            LocalDateTime localDateTime = LocalDateTime.now();
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//            String createTime = formatter.format(localDateTime);
            String createTime = DateUtils.getDate("yyyy-MM-dd HH:mm:ss");
            log.put("createTime", createTime);

            executorService.submit(new SaveLogThread(log));
        }

    }

    /**
     * 保存日志线程
     */
    public static class SaveLogThread extends Thread {

        private Map log;

        public SaveLogThread(Map log) {
            super(SaveLogThread.class.getSimpleName());
            this.log = log;
        }

        @Override
        public void run() {
//            dsRestClient.post(DsRestClient.Type.loadBalance, "http://" + systemUrl + "/sys/dsSysLog/save", log);
            String id = log.get("id").toString();
            String type = log.get("type").toString();
            String ip = log.get("ip").toString();
            // 保存日志信息入日志表
            System.out.println("本机的ip地址为:"+ip);
        }
    }


}

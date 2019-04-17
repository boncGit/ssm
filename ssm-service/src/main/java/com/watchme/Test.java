package com.watchme;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class Test {
    public static void main(String[] args){
        String str = "{X_PROCESS_RESULT:\"\",\"X_STATUS\":\"S\",\"X_MESSAGE\":null,\"X_RESERVED1\":\"\",\"X_RESERVED2\":\"\",\"X_RESERVED3\":\"\"}";
        str.replace("\\","");
        JSONObject json = JSONObject.parseObject(str);
        //System.out.println(json);
    }
}

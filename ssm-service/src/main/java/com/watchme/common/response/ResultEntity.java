package com.watchme.common.response;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * @author: wangqiang
 * @date: 2018/5/3 15:56
 * @description:
 */
public class ResultEntity {
    /**
     * error_code
     */
    private Integer code;

    /**
     * error_msg
     */
    private String msg;

    /**
     * content
     */
    private String data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getData() {
        return data;
    }

    public void setData(String tempData){
        this.data = tempData;
    }

    public void setData(Object data) {
        if (data != null) {
            String tempData = null;
            if (data instanceof String) {
                tempData = (String) data;
            } else {
                //
                tempData = JSON.toJSONString(data, //SerializerFeature.PrettyFormat,
                        SerializerFeature.WriteMapNullValue,
                        SerializerFeature.WriteNullStringAsEmpty,
                        SerializerFeature.DisableCircularReferenceDetect,
                        SerializerFeature.WriteNullListAsEmpty,
                        SerializerFeature.WriteDateUseDateFormat);
            }
            setData(tempData);
        }
    }


}

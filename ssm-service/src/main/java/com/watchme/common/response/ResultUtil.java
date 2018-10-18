package com.watchme.common.response;


import com.watchme.common.exception.ExceptionEnum;

/**
 * @author: wangqiang
 * @date: 2018/5/3 15:56
 * @description:
 */
public class ResultUtil {

    public static ResultEntity success() {
        return success(null);
    }
    public static ResultEntity success(Object object) {
        return success("success",object);
    }
    public static ResultEntity success(String msg,Object object) {
        ResultEntity result = new ResultEntity();
        result.setCode(0);
        result.setMsg(msg);
        result.setData(object);
        return result;
    }

    public static ResultEntity error(Integer code, String msg) {
        ResultEntity result = new ResultEntity();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(null);
        return result;
    }

    public static ResultEntity error(ExceptionEnum exceptionEnum) {
        ResultEntity result = new ResultEntity();
        result.setCode(exceptionEnum.getCode());
        result.setMsg(exceptionEnum.getMsg());
        result.setData(null);
        return result;
    }
    public static ResultEntity error(String msg) {
        ResultEntity result = new ResultEntity();
        result.setCode(ExceptionEnum.BUSINESS.getCode());
        result.setMsg(msg);
        result.setData(null);
        return result;
    }

}

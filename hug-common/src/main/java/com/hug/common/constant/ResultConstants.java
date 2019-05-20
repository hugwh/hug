package com.hug.common.constant;

/**
 * 错误码 常量类
 *
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-05-20 16:53
 */
public class ResultConstants {

    //返回状态
    public static final int STATUS_OK = 0;
    public static final String STATUS_MSG_OK = "ok";
    //返回状态
    public static final int STATUS_ERR = -1;
    public static final String STATUS_MSG_ERR = "error";
    //错误码分隔符
    public static final String SPLIT_STR = ".";

    //返回对象：开发人员 前端应透传
    public static final String TYPE_UNVARNISHED_TRANSMISSION = "0";
    //返回对象：用户 前端应返回给用户显示
    public static final String TYPE_REMIND = "1";

    //权限异常
    public static final String CODE_AUTH_ERR = "100";
    //连接异常
    public static final String CODE_CLIENT_ERR = "200";
    //超时异常
    public static final String CODE_TIME_OUT_ERR = "300";
    //参数异常
    public static final String CODE_PARAM_ERR = "400";
    //系统异常
    public static final String CODE_SYS_ERR = "500";
}

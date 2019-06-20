package com.hug.common.constant.enums.result;

/**
 * 响应编码
 *
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-06-20 11:32
 */
public enum CodeEnum {
    OK(200),            //成功
    AUTH_ERR(100),      //验证异常，权限异常
    CLIENT_ERR(300),    //连接异常
    TIME_OUT_ERR(400),  //超时异常
    PARAM_ERR(500),     //参数异常
    SYS_ERR(900),       //系统异常
    ;

    private int code;

    CodeEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}

package com.hug.common.exception;

/**
 * 业务异常
 *
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-04-02 16:29
 */
public class BusinessException extends RuntimeException {
    private Integer code;

    public BusinessException() {
        super();
    }

    public BusinessException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(String message) {
        super(message);
    }

    // 用指定的详细信息和原因构造一个新的异常
    public BusinessException(String message, Throwable cause){
        super(message,cause);
    }

    //用指定原因构造一个新的异常
    public BusinessException(Throwable cause) {
        super(cause);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}

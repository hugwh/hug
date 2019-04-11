package com.hug.common.exception;

/**
 * 业务异常
 *
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-04-02 16:29
 */
public class BusinessException extends RuntimeException {
    private Integer status;

    public BusinessException() {
        super();
    }

    public BusinessException(Integer status, String message) {
        super(message);
        this.status = status;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}

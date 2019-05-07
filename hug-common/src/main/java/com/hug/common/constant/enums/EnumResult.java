package com.hug.common.constant.enums;

/**
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-04-11 11:09
 */
public enum  EnumResult {
    SUCESS(0, "ok"),
    ERROR(-1, "error"),
            ;
    private Integer status;
    private String message;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private EnumResult(Integer status, String message) {
        this.status = status;
        this.message = message;
    }
}

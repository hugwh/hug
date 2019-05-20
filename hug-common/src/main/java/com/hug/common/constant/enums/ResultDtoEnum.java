package com.hug.common.constant.enums;

import com.hug.common.constant.ResultConstants;

/**
 * 返回结果枚举
 *
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-05-20 18:19
 */
public enum ResultDtoEnum {
    OK(ResultConstants.STATUS_OK, "ok"),
    ;
    private Integer status;
    private String msg;

    private ResultDtoEnum(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

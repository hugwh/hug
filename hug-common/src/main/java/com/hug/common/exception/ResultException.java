package com.hug.common.exception;

import lombok.Data;

/**
 * 自定义异常
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-05-20 18:24
 */
@Data
public class ResultException extends RuntimeException {
    /**
     * 错误码
     */
    private String code;
    /**
     * 展示类型 透传 or 提醒
     */
    private String type;
    /**
     * 信息
     */
    private String msg;

    public ResultException(String code, String type, String msg) {
        super(msg);
        this.code = code;
        this.type = type;
        this.msg = msg;
    }
}

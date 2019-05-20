package com.hug.common.exception;

import lombok.Data;

/**
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-05-20 18:24
 */
@Data
public class ResultException extends RuntimeException {

    private String code;
    private String to;
    private String msg;

    public ResultException(String code, String to, String msg) {
        super(msg);
        this.code = code;
        this.to = to;
        this.msg = msg;
    }
}

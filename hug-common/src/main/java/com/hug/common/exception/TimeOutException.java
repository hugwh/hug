package com.hug.common.exception;

import com.hug.common.constant.ResultConstants;

/**
 * 超时异常
 * @author: huangwh
 * @date: 2019/5/20 21:33
 */
public class TimeOutException extends ResultException {
    public TimeOutException(String type, String msg) {
        super(ResultConstants.CODE_TIME_OUT_ERR, type, msg);
    }
}

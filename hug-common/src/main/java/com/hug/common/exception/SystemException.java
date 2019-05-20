package com.hug.common.exception;

import com.hug.common.constant.ResultConstants;

/**
 * 系统异常
 * @author: huangwh
 * @date: 2019/5/20 21:33
 */
public class SystemException extends ResultException {
    public SystemException(String type, String msg) {
        super(ResultConstants.CODE_SYS_ERR, type, msg);
    }
}

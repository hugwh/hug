package com.hug.common.exception;

import com.hug.common.constant.ResultConstants;

/**
 * 认证异常
 * @author: huangwh
 * @date: 2019/5/20 21:33
 */
public class AuthException extends ResultException {

    public AuthException(String type, String msg) {
        super(ResultConstants.CODE_AUTH_ERR, type, msg);
    }
}

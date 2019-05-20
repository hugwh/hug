package com.hug.common.exception;

import com.hug.common.constant.ResultConstants;

/**
 * 连接异常
 * @author: huangwh
 * @date: 2019/5/20 21:33
 */
public class ClientException extends ResultException {
    public ClientException(String type, String msg) {
        super(ResultConstants.CODE_CLIENT_ERR, type, msg);
    }
}

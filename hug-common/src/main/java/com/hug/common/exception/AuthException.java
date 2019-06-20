package com.hug.common.exception;

import com.hug.common.constant.enums.result.CodeEnum;
import com.hug.common.constant.enums.result.DisplayEnum;
import com.hug.common.constant.enums.result.ServiceEnum;

/**
 * 认证异常
 * @author: huangwh
 * @date: 2019/5/20 21:33
 */
public class AuthException extends ResultException {

    public AuthException(String msg, ServiceEnum serviceEnum, DisplayEnum displayEnum) {
        super(CodeEnum.AUTH_ERR, msg, serviceEnum, displayEnum);
    }

    public AuthException(CodeEnum codeEnum, String msg, ServiceEnum serviceEnum, DisplayEnum displayEnum) {
        super(codeEnum, msg, serviceEnum, displayEnum);
    }
}

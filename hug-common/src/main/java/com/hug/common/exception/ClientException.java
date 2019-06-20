package com.hug.common.exception;

import com.hug.common.constant.enums.result.CodeEnum;
import com.hug.common.constant.enums.result.DisplayEnum;
import com.hug.common.constant.enums.result.ServiceEnum;

/**
 * 连接异常
 * @author: huangwh
 * @date: 2019/5/20 21:33
 */
public class ClientException extends ResultException {

    public ClientException(String msg, ServiceEnum serviceEnum, DisplayEnum displayEnum) {
        super(CodeEnum.CLIENT_ERR, msg, serviceEnum, displayEnum);
    }

    public ClientException(CodeEnum codeEnum, String msg, ServiceEnum serviceEnum, DisplayEnum displayEnum) {
        super(codeEnum, msg, serviceEnum, displayEnum);
    }
}

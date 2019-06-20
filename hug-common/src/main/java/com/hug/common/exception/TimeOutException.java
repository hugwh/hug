package com.hug.common.exception;

import com.hug.common.constant.enums.result.CodeEnum;
import com.hug.common.constant.enums.result.DisplayEnum;
import com.hug.common.constant.enums.result.ServiceEnum;

/**
 * 超时异常
 * @author: huangwh
 * @date: 2019/5/20 21:33
 */
public class TimeOutException extends ResultException {

    public TimeOutException(String msg, ServiceEnum serviceEnum, DisplayEnum displayEnum) {
        super(CodeEnum.TIME_OUT_ERR, msg, serviceEnum, displayEnum);
    }

    public TimeOutException(CodeEnum codeEnum, String msg, ServiceEnum serviceEnum, DisplayEnum displayEnum) {
        super(codeEnum, msg, serviceEnum, displayEnum);
    }
}

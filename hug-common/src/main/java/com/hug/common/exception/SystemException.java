package com.hug.common.exception;

import com.hug.common.constant.enums.result.CodeEnum;
import com.hug.common.constant.enums.result.DisplayEnum;
import com.hug.common.constant.enums.result.ServiceEnum;

/**
 * 系统异常
 * @author: huangwh
 * @date: 2019/5/20 21:33
 */
public class SystemException extends ResultException {

    public SystemException(String msg, ServiceEnum serviceEnum, DisplayEnum displayEnum) {
        super(CodeEnum.SYS_ERR, msg, serviceEnum, displayEnum);
    }

    public SystemException(CodeEnum codeEnum, String msg, ServiceEnum serviceEnum, DisplayEnum displayEnum) {
        super(codeEnum, msg, serviceEnum, displayEnum);
    }
}

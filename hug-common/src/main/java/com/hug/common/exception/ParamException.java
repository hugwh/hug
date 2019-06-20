package com.hug.common.exception;

import com.hug.common.constant.enums.result.CodeEnum;
import com.hug.common.constant.enums.result.DisplayEnum;
import com.hug.common.constant.enums.result.ServiceEnum;

/**
 * 参数异常
 * @author: huangwh
 * @date: 2019/5/20 21:31
 */
public class ParamException extends ResultException{

    public ParamException(String msg, ServiceEnum serviceEnum, DisplayEnum displayEnum) {
        super(CodeEnum.PARAM_ERR, msg, serviceEnum, displayEnum);
    }

    public ParamException(CodeEnum codeEnum, String msg, ServiceEnum serviceEnum, DisplayEnum displayEnum) {
        super(codeEnum, msg, serviceEnum, displayEnum);
    }
}

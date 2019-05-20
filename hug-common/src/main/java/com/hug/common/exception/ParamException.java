package com.hug.common.exception;

import com.hug.common.constant.ResultConstants;

/**
 * 参数异常
 * @author: huangwh
 * @date: 2019/5/20 21:31
 */
public class ParamException extends ResultException{
    public ParamException(String type, String msg) {
        super(ResultConstants.CODE_PARAM_ERR, type, msg);
    }
}

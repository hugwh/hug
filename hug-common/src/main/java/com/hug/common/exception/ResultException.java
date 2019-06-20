package com.hug.common.exception;

import com.hug.common.constant.enums.result.CodeEnum;
import com.hug.common.constant.enums.result.DisplayEnum;
import com.hug.common.constant.enums.result.ServiceEnum;
import lombok.Data;

/**
 * 自定义异常
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-05-20 18:24
 */
@Data
public class ResultException extends RuntimeException {
    /**
     * 错误码
     */
    private CodeEnum code;
    /**
     * 信息
     */
    private String msg;
    /**
     * 响应服务标识
     */
    private ServiceEnum from;

    /**
     * 展示类型 透传 or 提醒
     */
    private int display;

    public ResultException(CodeEnum codeEnum, String msg, ServiceEnum serviceEnum,  DisplayEnum displayEnum) {
        this.code = codeEnum;
        this.msg = msg;
        this.from = serviceEnum;
        this.display = displayEnum.getValue();
    }
}

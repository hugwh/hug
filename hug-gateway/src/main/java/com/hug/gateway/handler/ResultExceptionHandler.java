package com.hug.gateway.handler;

import com.hug.common.constant.enums.result.CodeEnum;
import com.hug.common.constant.enums.result.ServiceEnum;
import com.hug.common.exception.ResultException;
import com.hug.common.model.dto.ResultBaseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 异常全局处理
 *
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-05-20 18:28
 */
@Slf4j
@ControllerAdvice
public class ResultExceptionHandler {

    @ExceptionHandler({ResultException.class})
    @ResponseBody
    public ResultBaseDto handlerResultException(ResultException ex) {
        return new ResultBaseDto(ex.getCode(), ex.getMsg(), ex.getFrom());
    }

    @ExceptionHandler({Exception.class})
    @ResponseBody
    public ResultBaseDto handlerException(ResultException ex) {
        return new ResultBaseDto(CodeEnum.SYS_ERR, ex.getMsg(), ServiceEnum.HUG_GATEWAY);
    }
}

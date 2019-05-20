package com.hug.gateway.handler;

import com.hug.common.constant.ResultConstants;
import com.hug.common.exception.ResultException;
import com.hug.common.model.dto.ResultDto;
import com.hug.common.util.sys.ResultCode;
import com.hug.gateway.constants.GateWayConstants;
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
    public ResultDto handlerResultException(ResultException ex) {
        String code = ResultCode.build(GateWayConstants.SERVER_CODE, ex.getType(), ex.getCode());
        return new ResultDto(ResultConstants.STATUS_ERR, code, ex.getMsg(), null);
    }
}

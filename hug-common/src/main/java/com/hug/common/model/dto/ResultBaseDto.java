package com.hug.common.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.hug.common.constant.enums.result.CodeEnum;
import com.hug.common.constant.enums.result.ServiceEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 返回结果基础类
 *
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-06-20 10:29
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
public class ResultBaseDto {
    private Integer code;
    private String msg;
    private ServiceEnum from;

    public ResultBaseDto(){}

    public ResultBaseDto(CodeEnum codeEnum, String msg, ServiceEnum serviceEnum) {
        this.code = codeEnum.getCode();
        this.msg = msg;
        this.from = serviceEnum;
    }
}

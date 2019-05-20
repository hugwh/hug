package com.hug.common.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 接口返回结果
 *
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-05-20 17:49
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResultDto<T> {
    private Integer status;
    private String code;
    private String msg;
    private T data;
}

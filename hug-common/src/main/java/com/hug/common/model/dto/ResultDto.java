package com.hug.common.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 接口返回结果
 *
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-05-20 17:49
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
public class ResultDto<T> extends ResultBaseDto {
    private T data;
}

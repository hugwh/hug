package com.hug.common.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.hug.common.constant.enums.result.DisplayEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 返回结果
 *
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-06-20 11:23
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
public class ResultWebDto extends ResultDto {
    /**
     * 显示方式 透传或者显示给用户
     */
    private DisplayEnum diplay;
}

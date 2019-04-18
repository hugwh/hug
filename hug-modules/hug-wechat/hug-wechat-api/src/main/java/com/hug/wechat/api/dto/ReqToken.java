package com.hug.wechat.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * 请求token参数
 *
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-04-18 17:45
 */
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
public class ReqToken {
    private String grant_type;
    private String appid;
    private String secret;
}

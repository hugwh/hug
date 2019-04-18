package com.hug.wechat.api.dto;

import com.hug.common.dto.BaseEntity;
import lombok.*;

/**
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-04-18 11:13
 */

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class WechatAuth extends BaseEntity {
    private String signature;
    private String timestamp;
    private String nonce;
    private String echostr;
}

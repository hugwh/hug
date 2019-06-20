package com.hug.wechat.api.vo;

import lombok.*;

import java.io.Serializable;

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
public class WechatAuthVO implements Serializable {
    private String signature;
    private String timestamp;
    private String nonce;
    private String echostr;
}

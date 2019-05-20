package com.hug.wechat.api.vo;

import com.hug.common.model.vo.BaseVO;
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
public class WechatAuthVO extends BaseVO {
    private String signature;
    private String timestamp;
    private String nonce;
    private String echostr;
}

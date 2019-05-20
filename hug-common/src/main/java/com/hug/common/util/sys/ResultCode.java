package com.hug.common.util.sys;

import com.hug.common.constant.ResultConstants;

/**
 * 返回结果 错误码
 * 示例：
 * USER.1.200
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-05-20 17:59
 */
public class ResultCode {

    public static String build(String serverCode, String typeCode, String errCode) {
        return new StringBuffer()
                .append(serverCode.toUpperCase())
                .append(ResultConstants.SPLIT_STR)
                .append(typeCode)
                .append(ResultConstants.SPLIT_STR)
                .append(errCode)
                .toString();
    }
}

package com.hug.common.dto;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hug.common.constant.enums.EnumResult;
import com.hug.common.util.JsonUtils;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-04-11 11:07
 */
@Data
public class Result<T> implements Serializable {
    private Integer code;
    private String message;
    private T data;

    public static String toString(Result result) {
        return JSON.toJSON(result).toString();
    }

    public static Result toResult(String r) {
        Result result = new Result();
        if (r != null && r != "") {
            JSONObject rj = JsonUtils.string2Json(r);
            result.setCode(rj.getInteger("code"));
            result.setMessage(rj.getString("message"));
            if (rj.get("data") != null) {
                Object data = rj.get("data");
                result.setData(data);
            }
        }
        return result;
    }

    public Result() {}

    public Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Result successResult(T data) {
        this.code = EnumResult.SUCESS.getStatus();
        this.message = EnumResult.SUCESS.getMessage();
        this.data = data;

        return this;
    }

    public Result successResult() {
        this.code = EnumResult.SUCESS.getStatus();
        this.message = EnumResult.SUCESS.getMessage();

        return this;
    }
}

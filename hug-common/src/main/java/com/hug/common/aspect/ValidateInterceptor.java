package com.hug.common.aspect;

import com.alibaba.fastjson.JSONObject;
import com.hug.common.annotation.JsonSchemaValidate;
import com.hug.common.constant.Constants;
import com.hug.common.jsonschema.JsonSchemaUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 参数校验
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-04-02 11:40
 */
@Slf4j
@Aspect
@Component
public class ValidateInterceptor {

    @Pointcut("@annotation(com.hug.common.annotation.JsonSchemaValidate)")
    public void exPointCut() {}

    @Before("exPointCut() && @annotation(validateParams)")
    public void before (JoinPoint joinPoint, JsonSchemaValidate validateParams) throws Exception {
        //获取注解的值
        String schemaPath = validateParams.schemaPath();

        //获取参数
        Object[] args = joinPoint.getArgs();
        JSONObject rParams = (JSONObject) args[args.length - 1];

        //参数校验
        if (StringUtils.isNotBlank(schemaPath)) {
            schemaPath = new StringBuffer().append(Constants.SCHEMA_PATH_PREFIX).append(schemaPath)
                    .append(Constants.SCHEMA_PATH_SUFFIX).toString();
            JsonSchemaUtil.validateJson(rParams.toJSONString(), schemaPath);
        }
    }
}

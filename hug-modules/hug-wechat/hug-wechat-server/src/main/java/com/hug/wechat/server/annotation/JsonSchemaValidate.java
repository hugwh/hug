package com.hug.wechat.server.annotation;

import java.lang.annotation.*;

/**
 * 自定义注解 jsonschema校验json参数
 *
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2018-11-30 14:32
 */
@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface JsonSchemaValidate {
    /**
     * 验证参数
     * @return
     */
    String schemaPath() default "";
}

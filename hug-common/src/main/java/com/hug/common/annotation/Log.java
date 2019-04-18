package com.hug.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-04-02 10:27
 */
@Documented
@Retention(RUNTIME)
@Target(ElementType.METHOD)
public @interface Log {
    String value() default "日志注解";
}

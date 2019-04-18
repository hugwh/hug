package com.hug.common.aspect;

import com.hug.common.dto.Result;
import com.hug.common.exception.BusinessException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * service类参数校验切面
 *
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2018-11-30 14:09
 */
@Aspect
@Component
public class LogAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("@annotation(com.hug.common.annotation.Log)")
    public void exPointCut() {}

    @Before("exPointCut()")
    public void before (JoinPoint joinPoint) {
        try {

            // 接收到请求，记录请求内容
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = attributes.getRequest();
            // 记录下请求内容
            logger.info("--->URL : " + request.getRequestURL().toString());
            logger.info("--->HTTP_METHOD : " + request.getMethod());
            logger.info("--->IP : " + request.getRemoteAddr());
            logger.info("--->CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
            logger.info("--->PARAMS : " + Arrays.toString(joinPoint.getArgs()));

        }catch (Exception e) {
            this.logger.debug("--->切面日志无法获取请求");
        }

    }

    @Around("exPointCut()")
    public Object around (ProceedingJoinPoint pjp) throws Throwable {
        logger.info("--->方法执行中.....");
        try {
            Object o =  pjp.proceed();
//            logger.info("--->方法执行，结果是 :" + o);
            return o;
        } catch (Throwable e) {
            if (e instanceof BusinessException) {
                logger.warn("--->异常类型："+String.valueOf(e.getClass()));
                logger.warn("--->异常信息："+e.getMessage());
            }else {
                e.printStackTrace();
                logger.error(String.valueOf(e.getClass()));
            }
            throw e;
        }
    }

    @After("exPointCut()")
    public void after (JoinPoint joinPoint) {
        logger.info("--->方法最后执行。。。。");
    }

    @AfterReturning(returning = "ret", pointcut = "exPointCut()")
    public void doAfterReturning (Object ret) {
        if (ret instanceof String) {
            //处理完请求，返回内容
            logger.info("--->方法的返回值：" + ret);
        }

        if (ret instanceof Result) {
            //处理完请求，返回内容
            logger.info("--->方法的返回值：" + Result.toString((Result)ret));
        }
    }

//    @AfterThrowing ("exPointCut()")
//    public void throwss(JoinPoint joinPoint) {
//        logger.error("方法异常时执行。。。。");
//        logger.error(joinPoint.toString());
//    }


}

package com.ssq.demo.jdauto.log.annotation;


import com.ssq.demo.jdauto.log.enums.LogLevel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: 苏诗淇
 * @CreateDate: 2020/4/28 2:37 下午
 * @Description: aop日志
 */
@Target(value = {ElementType.METHOD})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface AopLog {

    String value() default "";

    String[] logArgs() default "";

    boolean record() default true;

    LogLevel logLevel() default LogLevel.DEBUG;
}

package com.ssq.demo.jdauto.util.mvc.annotation;

import java.lang.annotation.*;

/**
 * @author 王守钰
 * @program jdauto
 * @date 2020年04月26日 08:38
 * @description: 返回包装结果
 */
@Documented
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = {ElementType.TYPE, ElementType.METHOD})
public @interface ResponseBodyResult {
}

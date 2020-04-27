package com.ssq.demo.jdauto.util.mvc.annotation;

import java.lang.annotation.*;

/**
 * @ Author : 苏诗淇
 * @ CreateDate: 2020/4/26 7:42 下午
 * @ Description: 参数别名
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ParamAlias {
    /**
     * 参数别名
     */
    String [] value();

}

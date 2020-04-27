package com.ssq.demo.jdauto.util.exception;
/**
 * @ Author : 苏诗淇
 * @ CreateDate: 2020/4/26 7:32 下午
 * @ Description: 京东汽车商城默认异常(父子项目是可复用)
 */
public class JdautoException extends RuntimeException{

    public JdautoException() {
    }

    public JdautoException(String message) {
        super(message);
    }

    public JdautoException(String message, Throwable cause) {
        super(message, cause);
    }

    public JdautoException(Throwable cause) {
        super(cause);
    }

    public JdautoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

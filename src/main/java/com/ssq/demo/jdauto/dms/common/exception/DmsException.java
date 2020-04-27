package com.ssq.demo.jdauto.dms.common.exception;

import com.ssq.demo.jdauto.util.exception.JdautoException;
/**
 * @ Author : 苏诗淇
 * @ CreateDate: 2020/4/26 7:40 下午
 * @ Description: dms异常
 */
public class DmsException extends JdautoException {

    public DmsException() {
    }

    public DmsException(String message) {
        super(message);
    }

    public DmsException(String message, Throwable cause) {
        super(message, cause);
    }

    public DmsException(Throwable cause) {
        super(cause);
    }

    public DmsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

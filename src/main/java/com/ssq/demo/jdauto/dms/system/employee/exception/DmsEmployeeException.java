package com.ssq.demo.jdauto.dms.system.employee.exception;

import com.ssq.demo.jdauto.dms.common.commondata.exception.DmsException;
/**
 * @Author: 苏诗淇
 * @CreateDate: 2020/5/7 8:49 下午
 * @Description: dms员工异常
 */
public class DmsEmployeeException extends DmsException {
    public DmsEmployeeException(Integer errorCode) {
        super(errorCode);
    }

    public DmsEmployeeException(String message, Integer errorCode) {
        super(message, errorCode);
    }

    public DmsEmployeeException(String message, Throwable cause, Integer errorCode) {
        super(message, cause, errorCode);
    }

    public DmsEmployeeException(Throwable cause, Integer errorCode) {
        super(cause, errorCode);
    }

    public DmsEmployeeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, Integer errorCode) {
        super(message, cause, enableSuppression, writableStackTrace, errorCode);
    }

    public DmsEmployeeException() {
    }

    public DmsEmployeeException(String message) {
        super(message);
    }

    public DmsEmployeeException(String message, Throwable cause) {
        super(message, cause);
    }

    public DmsEmployeeException(Throwable cause) {
        super(cause);
    }

    public DmsEmployeeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

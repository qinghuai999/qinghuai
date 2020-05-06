package com.ssq.demo.jdauto.dms.common.commondata.exception;

import com.ssq.demo.jdauto.util.exception.JdautoException;
/**
 * @Author: 苏诗淇
 * @CreateDate: 2020/5/6 9:47 下午
 * @Description: dms异常
 */
public class DmsException extends JdautoException {

    /**
     * 错误码
     */
    private Integer errorCode;

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public DmsException(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public DmsException(String message, Integer errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public DmsException(String message, Throwable cause, Integer errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public DmsException(Throwable cause, Integer errorCode) {
        super(cause);
        this.errorCode = errorCode;
    }

    public DmsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, Integer errorCode) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.errorCode = errorCode;
    }

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

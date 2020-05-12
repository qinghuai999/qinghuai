package com.ssq.demo.jdauto.dms.system.role.exception;

import com.ssq.demo.jdauto.dms.common.commondata.exception.DmsException;
import com.ssq.demo.jdauto.util.exception.JdautoException;

/**
 * @Author: 苏诗淇
 * @CreateDate: 2020/5/8 9:42 下午
 * @Description: dms角色异常
 */
public class DmsRoleException extends DmsException {
    public DmsRoleException(Integer errorCode) {
        super(errorCode);
    }

    public DmsRoleException(String message, Integer errorCode) {
        super(message, errorCode);
    }

    public DmsRoleException(String message, Throwable cause, Integer errorCode) {
        super(message, cause, errorCode);
    }

    public DmsRoleException(Throwable cause, Integer errorCode) {
        super(cause, errorCode);
    }

    public DmsRoleException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, Integer errorCode) {
        super(message, cause, enableSuppression, writableStackTrace, errorCode);
    }

    public DmsRoleException() {
    }

    public DmsRoleException(String message) {
        super(message);
    }

    public DmsRoleException(String message, Throwable cause) {
        super(message, cause);
    }

    public DmsRoleException(Throwable cause) {
        super(cause);
    }

    public DmsRoleException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

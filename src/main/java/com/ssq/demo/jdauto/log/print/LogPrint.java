package com.ssq.demo.jdauto.log.print;

import com.ssq.demo.jdauto.log.annotation.AopLog;
import com.ssq.demo.jdauto.log.enums.LogLevel;

import java.util.Map;

/**
 * @Author: 苏诗淇
 * @CreateDate: 2020/4/30 10:04 上午
 * @Description: 日志打印
 */
public interface LogPrint {
    /**
     * aop 日志打印
     * @param logLevel 日志级别
     * @param method 方法
     * @param params 参数
     * @param aopLog 注解
     */
    void printLog(LogLevel logLevel, String method, Map<String, Object> params, AopLog aopLog);

    /**
     * 打印执行时长
     * @param logLevel
     * @param method
     * @param aopLog
     * @param execTime
     */
    void printExecTime(LogLevel logLevel, String method, AopLog aopLog, Long execTime);
}

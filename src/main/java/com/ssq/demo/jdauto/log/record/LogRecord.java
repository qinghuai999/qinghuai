package com.ssq.demo.jdauto.log.record;

import com.ssq.demo.jdauto.log.annotation.AopLog;

import java.util.Map;

/**
 * @Author: 苏诗淇
 * @CreateDate: 2020/4/30 1:29 下午
 * @Description: 日志记录器
 */
public interface LogRecord {

    /**
     * 记录请求开始日志
     * @param method 类方法
     * @param params 请求参数
     * @param aopLog aop日志
     */
    void recordStartLog(String method, Map<String, Object> params, AopLog aopLog);

    /**
     * 记录请求结束日志
     * @param method 类方法
     * @param execTime 执行时间
     * @param aopLog 执行日志
     */
    void endLog(String method, Long execTime, AopLog aopLog);
}

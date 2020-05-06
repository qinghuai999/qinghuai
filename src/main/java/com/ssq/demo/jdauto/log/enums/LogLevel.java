package com.ssq.demo.jdauto.log.enums;
/**
 * @Author: 苏诗淇
 * @CreateDate: 2020/4/28 2:44 下午
 * @Description: 日志级别
 */
public enum LogLevel {
    /**
     * 日志级别
     */
    TRACE,
    DEBUG,
    INFO,
    WARN,
    ERROR,
    FATAL,
    OFF;

    private LogLevel() {
    }
}

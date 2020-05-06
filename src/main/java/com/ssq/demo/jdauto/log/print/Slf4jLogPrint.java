package com.ssq.demo.jdauto.log.print;

import com.alibaba.fastjson.JSONObject;
import com.ssq.demo.jdauto.log.annotation.AopLog;
import com.ssq.demo.jdauto.log.enums.LogLevel;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
/**
 * @Author: 苏诗淇
 * @CreateDate: 2020/4/30 10:40 上午
 * @Description: slf4j日志打印
 */
@Slf4j
public class Slf4jLogPrint implements LogPrint {
    @Override
    public void printLog(LogLevel logLevel, String method, Map<String, Object> params, AopLog aopLog) {
        switch (logLevel){
            case TRACE:
                log.trace("{},request method:{}, params:{}",aopLog.value(), method, JSONObject.toJSONString(params));
                break;
            case DEBUG:
                log.debug("{},request method:{}, params:{}", aopLog.value(), method, JSONObject.toJSONString(params));
                break;
            case INFO:
                log.info("{}, request method:{}, params:{}", aopLog, method, JSONObject.toJSONString(params));
                break;
            case WARN:
                log.warn("{}, request method:{}, params:{}", aopLog, method, JSONObject.toJSONString(params));
                break;
            case ERROR:
                log.error("{}, request method:{}, params:{}", aopLog, method, JSONObject.toJSONString(params));
            default:
                break;
        }
    }

    @Override
    public void printExecTime(LogLevel logLevel, String method, AopLog aopLog, Long execTime) {
        switch (logLevel){
            case TRACE:
                log.trace("request method:{}, execTime:{}", method, execTime);
                break;
            case DEBUG:
                log.debug("request method:{}, execTime:{}", method, execTime);
                break;
            case INFO:
                log.info("request method:{}, execTime:{}", method, execTime);
                break;
            case WARN:
                log.warn("request method:{}, execTime:{}", method, execTime);
                break;
            default:
                break;
        }
    }
}

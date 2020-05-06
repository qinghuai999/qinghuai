package com.ssq.demo.jdauto.log.record;

import com.ssq.demo.jdauto.log.annotation.AopLog;

import java.util.Map;

public class NoLogRecord implements LogRecord {
    @Override
    public void recordStartLog(String method, Map<String, Object> params, AopLog aopLog) {

    }

    @Override
    public void endLog(String method, Long execTime, AopLog aopLog) {

    }
}

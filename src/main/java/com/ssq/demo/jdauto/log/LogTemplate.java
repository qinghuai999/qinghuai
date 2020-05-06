package com.ssq.demo.jdauto.log;

import com.ssq.demo.jdauto.log.annotation.AopLog;
import com.ssq.demo.jdauto.log.enums.LogLevel;
import com.ssq.demo.jdauto.log.print.LogPrint;
import com.ssq.demo.jdauto.log.record.LogRecord;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.context.expression.MethodBasedEvaluationContext;
import org.springframework.core.DefaultParameterNameDiscoverer;
import org.springframework.core.ParameterNameDiscoverer;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 苏诗淇
 * @CreateDate: 2020/4/30 10:02 上午
 * @Description: 日志模版
 */
@Slf4j
public class LogTemplate {
    @Setter
    private LogPrint logPrint;

    @Setter
    private LogRecord logRecord;

    // 获取参数名称
    private static final ParameterNameDiscoverer NAME_DISCOVERER = new DefaultParameterNameDiscoverer();

    // 创建表达式解析器
    private static final ExpressionParser PARSER = new SpelExpressionParser();

    // 开始记录日志
    public void startLog (MethodInvocation invocation, AopLog aopLog){
        // MethodInvocation 方法执行器, 返回正在被调用的方法对象
        StringBuffer buffer = new StringBuffer();
        // 获取当前被调用的方法
        Method method = invocation.getMethod();
        // 在字符串对象中 追加一个类名和方法名
        buffer.append(method.getDeclaringClass().getName()).append(".").append(method.getName());
        Map<String, Object> map = new HashMap<>(8);
        EvaluationContext context = new MethodBasedEvaluationContext(null, method, invocation.getArguments(), NAME_DISCOVERER);
        for (String arg : aopLog.logArgs()){
            try {
                if (null != arg && !"".equals(arg)){
                    map.put(arg, PARSER.parseExpression(arg).getValue(context));
                }
            } catch (Exception e){

            }
        }
        // 如果日至等级不是OFF,打印日志
        if (!aopLog.logLevel().equals(LogLevel.OFF)){
            logPrint.printLog(aopLog.logLevel(),buffer.toString(),map,aopLog);
        }
        // 如果record为true,记录该方法日志
        if (aopLog.record()){
            logRecord.recordStartLog(buffer.toString(), map, aopLog);
        }
    }


    // 记录执行时间
    public void endLog(MethodInvocation invocation, AopLog aopLog, Long execTime){
        StringBuffer buffer = new StringBuffer();
        Method method = invocation.getMethod();
        buffer.append(method.getDeclaringClass().getName()).append(".").append(method.getName());
        if (!aopLog.logLevel().equals(LogLevel.OFF)){
            logPrint.printExecTime(aopLog.logLevel(), buffer.toString(),aopLog, execTime);
        }

        if (aopLog.record()){
            logRecord.endLog(buffer.toString(), execTime, aopLog);
        }
    }








}

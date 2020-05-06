package com.ssq.demo.jdauto.log.aop;

import com.ssq.demo.jdauto.log.LogTemplate;
import com.ssq.demo.jdauto.log.annotation.AopLog;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @Author: 苏诗淇
 * @CreateDate: 2020/4/30 9:57 上午
 * @Description: aop日志拦截器
 */
@Slf4j
public class AopLogInterceptor implements MethodInterceptor {
    @Setter
    private LogTemplate logTemplate;

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        // 返回当前时间(毫秒)
        Long startTime = System.currentTimeMillis();

        // 方法调用
        AopLog aopLog = invocation.getMethod().getAnnotation(AopLog.class);
        try {
            logTemplate.startLog(invocation,aopLog);
        } catch (Exception e){
            log.error("记录开始操作日志异常");
            log.error(e.getMessage(),e);
        }

        // 执行目标方法
        Object proceed = invocation.proceed();
        // 计算执行时间
        Long execTime = System.currentTimeMillis() - startTime;
        try {
            logTemplate.endLog(invocation, aopLog, execTime);
        } catch (Exception e){
            log.error("记录结束操作日志异常");
            log.error(e.getMessage(), e);
        }
        return proceed;
    }
}

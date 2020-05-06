package com.ssq.demo.jdauto.log.config;

import com.ssq.demo.jdauto.log.LogTemplate;
import com.ssq.demo.jdauto.log.aop.AopLogAnnotationAdvisor;
import com.ssq.demo.jdauto.log.aop.AopLogInterceptor;
import com.ssq.demo.jdauto.log.print.LogPrint;
import com.ssq.demo.jdauto.log.print.Slf4jLogPrint;
import com.ssq.demo.jdauto.log.record.LogRecord;
import com.ssq.demo.jdauto.log.record.NoLogRecord;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: 苏诗淇
 * @CreateDate: 2020/5/2 1:50 下午
 * @Description: aop日志配置
 */
@Configuration
public class AopLogConfiguration {

    /**
     * 日志打印
     */
    @Bean
    // 若该类不存在spring容器中,就使用该注解实例化到容器
    @ConditionalOnMissingBean
    public LogPrint logPrint(){
        return new Slf4jLogPrint();
    }

    /**
     * 日志记录
     */
    @Bean
    @ConditionalOnMissingBean
    public LogRecord logRecord(){
        return new NoLogRecord();
    }

    /**
     * 日志模板
     * @param logPrint
     * @param logRecord
     */
    @Bean
    @ConditionalOnMissingBean
    public LogTemplate logTemplate(LogPrint logPrint, LogRecord logRecord){
        LogTemplate logTemplate = new LogTemplate();
        logTemplate.setLogPrint(logPrint);
        logTemplate.setLogRecord(logRecord);
        return logTemplate;
    }

    /**
     * aop拦截器
     * @param logTemplate
     */
    @Bean
    @ConditionalOnMissingBean
    public AopLogInterceptor aopLogInterceptor(LogTemplate logTemplate){
        AopLogInterceptor logInterceptor = new AopLogInterceptor();
        logInterceptor.setLogTemplate(logTemplate);
        return logInterceptor;
    }

    /**
     * aop日志
     * @param aopLogInterceptor
     */
    @Bean
    @ConditionalOnMissingBean
    public AopLogAnnotationAdvisor aopLogAnnotationAdvisor(AopLogInterceptor aopLogInterceptor){
        return new AopLogAnnotationAdvisor(aopLogInterceptor);
    }


}

package com.ssq.demo.jdauto.lock.config;

import com.ssq.demo.jdauto.lock.LockTemplate;
import com.ssq.demo.jdauto.lock.aop.LockAnnotationAdvisor;
import com.ssq.demo.jdauto.lock.aop.LockInterceptor;
import com.ssq.demo.jdauto.lock.executors.LockExecutor;
import com.ssq.demo.jdauto.lock.executors.RedisTemplateLockExecutor;
import com.ssq.demo.jdauto.lock.key.SpelLockKeyGenrator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @Author: 苏诗淇
 * @CreateDate: 2020/5/6 7:05 下午
 * @Description: 锁配置信息
 */
@Configuration
public class LockConfiguration {

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnClass(RedisTemplate.class)
    public LockExecutor lockExecutor(RedisTemplate redisTemplate){
        // 创建一个redis锁执行器
        RedisTemplateLockExecutor  redisTemplateLockExecutor = new RedisTemplateLockExecutor();
        // 将数据注入redisTemplate
        redisTemplateLockExecutor.setRedisTemplate(redisTemplate);
        return redisTemplateLockExecutor;
    }

    @Bean
    @ConditionalOnMissingBean
    public LockTemplate lockTemplate(LockExecutor lockExecutor){
        LockTemplate lockTemplate = new LockTemplate();
        // 将锁执行器数据注入锁模版
        lockTemplate.setLockExecutor(lockExecutor);
        return lockTemplate;
    }

    @Bean
    @ConditionalOnMissingBean
    public LockAnnotationAdvisor lockAnnotationAdvisor(LockInterceptor lockInterceptor){
        LockAnnotationAdvisor annotationAdvisor = new LockAnnotationAdvisor(lockInterceptor, Integer.MAX_VALUE -1000);
        return annotationAdvisor;
    }

    @Bean
    @ConditionalOnMissingBean
    public LockInterceptor lockInterceptor(LockTemplate lockTemplate){
        LockInterceptor lockInterceptor = new LockInterceptor();
        lockInterceptor.setLockTemplate(lockTemplate);
        lockInterceptor.setLockKeyGenerator(new SpelLockKeyGenrator());
        return lockInterceptor;
    }

}

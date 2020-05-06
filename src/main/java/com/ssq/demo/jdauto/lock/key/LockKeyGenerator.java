package com.ssq.demo.jdauto.lock.key;

import com.ssq.demo.jdauto.lock.annotation.AopLock;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @Author: 苏诗淇
 * @CreateDate: 2020/5/2 3:15 下午
 * @Description: 锁key生成器
 */
public interface LockKeyGenerator {

    /**
     * 锁key的生成器
     * @param invocation
     * @param aopLock
     * @return 该锁生成的key
     */
    String getKeyName(MethodInvocation invocation, AopLock aopLock);
}

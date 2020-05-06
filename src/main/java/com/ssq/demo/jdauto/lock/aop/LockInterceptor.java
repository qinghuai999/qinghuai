package com.ssq.demo.jdauto.lock.aop;

import com.ssq.demo.jdauto.lock.LockInfo;
import com.ssq.demo.jdauto.lock.LockTemplate;
import com.ssq.demo.jdauto.lock.annotation.AopLock;
import com.ssq.demo.jdauto.lock.key.LockKeyGenerator;
import lombok.Setter;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @Author: 苏诗淇
 * @CreateDate: 2020/5/6 1:01 下午
 * @Description: 锁拦截器
 */
public class LockInterceptor implements MethodInterceptor {

    @Setter
    private LockTemplate lockTemplate;

    @Setter
    private LockKeyGenerator lockKeyGenerator;

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        LockInfo lockInfo = null;
        try {
            // 获取该注解下的方法名称
            AopLock lock = invocation.getMethod().getAnnotation(AopLock.class);
            // 获取锁的key
            String keyName = lockKeyGenerator.getKeyName(invocation, lock);
            // 将加锁信息放入实体
            lockInfo = lockTemplate.lock(keyName, lock.expire(), lock.timeout());
            // 若实体不为空
            if (null != lockInfo) {
                // 执行该目标方法
                return invocation.proceed();
            }

            return null;

        } finally {
            // 若实体不为空
            if (null != lockInfo){
                // 进行解锁
                lockTemplate.releaseLock(lockInfo);
            }
        }
    }
}

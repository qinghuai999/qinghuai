package com.ssq.demo.jdauto.lock.aop;

import com.ssq.demo.jdauto.lock.annotation.AopLock;
import lombok.NonNull;
import org.aopalliance.aop.Advice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.AbstractPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

/**
 * @Author: 苏诗淇
 * @CreateDate: 2020/5/6 4:56 下午
 * @Description: 锁aop配置
 */
public class LockAnnotationAdvisor extends AbstractPointcutAdvisor implements BeanFactoryAware {

    private Advice advice;

    private Pointcut pointcut;

    public LockAnnotationAdvisor(@NonNull LockInterceptor lockInterceptor, Integer integer) {
        this.advice = lockInterceptor;
        this.pointcut = buildPointcut();
        this.setOrder(integer);
    }

    @Override
    public Pointcut getPointcut() {
        return this.pointcut;
    }

    @Override
    public Advice getAdvice() {
        return this.advice;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        if (this.advice instanceof BeanFactoryAware){
            ((BeanFactoryAware) this.advice).setBeanFactory(beanFactory);
        }
    }

    private Pointcut buildPointcut(){
        // 通过注解寻找方法切点
        return AnnotationMatchingPointcut.forMethodAnnotation(AopLock.class);
    }
}

package com.ssq.demo.jdauto.log.aop;

import com.ssq.demo.jdauto.log.annotation.AopLog;
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
 * @CreateDate: 2020/4/28 5:15 下午
 * @Description: aop日志
 */
public class AopLogAnnotationAdvisor extends AbstractPointcutAdvisor implements BeanFactoryAware {

    private Advice advice;

    private Pointcut pointcut;

    public AopLogAnnotationAdvisor(@NonNull AopLogInterceptor advice) {
        this.advice = advice;
        this.pointcut = buildPointcut();
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
        if (this.advice instanceof BeanFactoryAware) {
            ((BeanFactoryAware) this.advice).setBeanFactory(beanFactory);
        }
    }

    private Pointcut buildPointcut(){
        return AnnotationMatchingPointcut.forMethodAnnotation(AopLog.class);
    }
}

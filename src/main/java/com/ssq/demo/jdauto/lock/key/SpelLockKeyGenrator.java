package com.ssq.demo.jdauto.lock.key;

import com.ssq.demo.jdauto.lock.annotation.AopLock;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.context.expression.MethodBasedEvaluationContext;
import org.springframework.core.DefaultParameterNameDiscoverer;
import org.springframework.core.ParameterNameDiscoverer;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 苏诗淇
 * @CreateDate: 2020/5/2 3:16 下午
 * @Description: Spel锁key生成器
 */
public class SpelLockKeyGenrator implements LockKeyGenerator{

    // 获取参数名称
    private static final ParameterNameDiscoverer NAME_DISCOVERER = new DefaultParameterNameDiscoverer();

    // 创建表达式解析器
    private static final ExpressionParser PARSER = new SpelExpressionParser();

    private static final String keySplit = ":";


    @Override
    public String getKeyName(MethodInvocation invocation, AopLock aopLock) {
        StringBuilder builder = new StringBuilder();
        // 获取方法名称
        Method method = invocation.getMethod();
        // 将方法名称放入对象
        builder.append(method.getDeclaringClass().getName()).append(".").append(method.getName());
        // 如果锁的key长度>1 或者起始下标不为空
        if (aopLock.keys().length > 1 || !"".equals(aopLock.keys()[0])){
            // 把锁的key,方法,获取的参数放入对象
            builder.append(getSpelDefinitionKey(aopLock.keys(), method, invocation.getArguments()));
        }
        return builder.toString();
    }

    private String getSpelDefinitionKey(String[] definitionKeys, Method method, Object[] parameterValues){
        // 记录方法及参数等
        EvaluationContext context = new MethodBasedEvaluationContext(null, method, parameterValues, NAME_DISCOVERER);
        List<String> definitionKeyList = new ArrayList<>(definitionKeys.length);
        // 循环定义的键
        for (String definitionKey : definitionKeys){
            // 如果该ley不为空
            if (definitionKey != null && !definitionKey.isEmpty()){
                // 解析该key,获得记录的值
                String key = PARSER.parseExpression(definitionKey).getValue(context).toString();
                definitionKeyList.add(key);
            }
        }
        return StringUtils.collectionToDelimitedString(definitionKeyList, "", keySplit, "");
    }
}

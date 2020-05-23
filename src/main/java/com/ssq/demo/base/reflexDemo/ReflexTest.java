package com.ssq.demo.base.reflexDemo;

import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
/**
 * @Author: 苏诗淇
 * @CreateDate: 2020/5/18 3:48 下午
 * @Description: 反射用法
 */
public class ReflexTest {
    public static void main(String[] args) {
        Method[] methods = String.class.getMethods();
        for (Method method : methods){
            // 获取该类所有方法名
            System.out.println(method.getName());

            // 获取指定注解对应方法
            RequestMapping annotation = method.getAnnotation(RequestMapping.class);
            System.out.println(annotation);
            System.out.println();

            // 获取类中所有注解
            Annotation[] annotations = method.getAnnotations();
            for (Annotation annotation1 : annotations){
                System.out.println(annotation1);
            }
        }
    }
}

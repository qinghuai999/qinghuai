package com.ssq.demo.base.aopdemo;

import net.sf.cglib.proxy.InvocationHandler;
import net.sf.cglib.proxy.Proxy;

import java.lang.reflect.Method;

/**
 * @Author: 苏诗淇
 * @CreateDate: 2020/5/26 7:09 下午
 * @Description: 代理类
 */
public class MyBeanFactory {
    public static UserService creatService(){
        // 1.目标类 --> 通过接口去调她的实现类
        final UserService userService = new UserServiceImpl();

        // 2.切面类
        final MyAspect myAspect = new MyAspect();

        // 3.切入点和切面类结合
        UserService proxyService = (UserService) Proxy.newProxyInstance(MyBeanFactory.class.getClassLoader(),
                userService.getClass().getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                        System.out.println(method.getName());
                        myAspect.before();
                        Object obj = method.invoke(userService,objects);
                        myAspect.after();
                        return obj;
                    }
                });
        return proxyService;
    }
}

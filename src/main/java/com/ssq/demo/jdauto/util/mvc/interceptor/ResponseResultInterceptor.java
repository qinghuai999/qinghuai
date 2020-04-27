package com.ssq.demo.jdauto.util.mvc.interceptor;

import com.ssq.demo.jdauto.util.mvc.annotation.ResponseBodyResult;
import com.ssq.demo.jdauto.util.mvc.constant.MvcConstant;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @ Author : 苏诗淇
 * @ CreateDate: 2020/4/26 8:41 下午
 * @ Description: 
 */
public class ResponseResultInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(handler instanceof HandlerMethod){
            // 注解匹配
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Class<?> clazz = handlerMethod.getBeanType();
            Method method = handlerMethod.getMethod();
            // 判断类上是否有ResponseR注解
            if(clazz.isAnnotationPresent(ResponseBodyResult.class) || method.isAnnotationPresent(ResponseBodyResult.class)){
                request.setAttribute(MvcConstant.RESPONSE_RESULT_ANN, ResponseBodyResult.class);
            }
        }
        return true;
    }
}

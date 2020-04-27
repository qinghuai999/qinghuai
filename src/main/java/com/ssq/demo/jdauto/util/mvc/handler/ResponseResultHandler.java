package com.ssq.demo.jdauto.util.mvc.handler;

import com.ssq.demo.jdauto.util.constant.AbstractJdautoErrorCode;
import com.ssq.demo.jdauto.util.mvc.constant.MvcConstant;
import com.ssq.demo.jdauto.util.mvc.response.ResponseResult;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @ Author : 苏诗淇
 * @ CreateDate: 2020/4/26 8:27 下午
 * @ Description: 返回结果处理器
 */

public class ResponseResultHandler implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        return request.getAttribute(MvcConstant.RESPONSE_RESULT_ANN)!= null;
    }

    @Override
    public Object beforeBodyWrite(Object body,
                                  MethodParameter methodParameter,
                                  MediaType mediaType,
                                  Class<? extends HttpMessageConverter<?>> aClass,
                                  ServerHttpRequest serverHttpRequest,
                                  ServerHttpResponse serverHttpResponse) {
        if (body instanceof ResponseResult){
            return body;
        }

        return ResponseResult.builder().code(AbstractJdautoErrorCode.SUCCEDD_CODE).data(body).build();
    }
}

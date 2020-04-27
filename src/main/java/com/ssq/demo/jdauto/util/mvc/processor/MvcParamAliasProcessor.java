package com.ssq.demo.jdauto.util.mvc.processor;

import com.ssq.demo.jdauto.util.mvc.annotation.ParamAlias;
import com.ssq.demo.jdauto.util.mvc.binder.ParamAliasDataBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.ServletModelAttributeMethodProcessor;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ Author : 苏诗淇
 * @ CreateDate: 2020/4/26 8:38 下午
 * @ Description: mvc别名配置
 */
public class MvcParamAliasProcessor extends ServletModelAttributeMethodProcessor {

    public MvcParamAliasProcessor(boolean annotationNotRequired) {
        super(annotationNotRequired);
    }

    @Autowired
    private RequestMappingHandlerAdapter requestMappingHandlerAdapter;

    private final Map<Class<?>, Map<String, String>> replaceMap = new ConcurrentHashMap<Class<?>, Map<String, String>>();


    @Override
    protected void bindRequestParameters(WebDataBinder binder, NativeWebRequest nativeWebRequest) {
        Object target = binder.getTarget();
        Class<?> targetClass = target.getClass();
        if (!replaceMap.containsKey(targetClass)) {
            Map<String, String> mapping = analyzeClass(targetClass);
            replaceMap.put(targetClass, mapping);
        }
        Map<String, String> mapping = replaceMap.get(targetClass);
        ParamAliasDataBinder paramNameDataBinder = new ParamAliasDataBinder(target, binder.getObjectName(), mapping);
        requestMappingHandlerAdapter.getWebBindingInitializer().initBinder(paramNameDataBinder, nativeWebRequest);
        super.bindRequestParameters(paramNameDataBinder, nativeWebRequest);
    }

    private static Map<String, String> analyzeClass(Class<?> targetClass) {
        Field[] fields = targetClass.getDeclaredFields();
        Map<String, String> renameMap = new HashMap<String, String>();
        for (Field field : fields) {
            ParamAlias paramNameAnnotation = field.getAnnotation(ParamAlias.class);
            if (paramNameAnnotation != null) {
                String[] values = paramNameAnnotation.value();
                for (String val : values){
                    renameMap.put(val, field.getName());
                }
            }
        }
        if (renameMap.isEmpty()){
            return Collections.emptyMap();
        }
        return renameMap;
    }
}

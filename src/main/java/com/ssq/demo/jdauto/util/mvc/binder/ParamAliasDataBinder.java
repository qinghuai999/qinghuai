package com.ssq.demo.jdauto.util.mvc.binder;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.web.servlet.mvc.method.annotation.ExtendedServletRequestDataBinder;

import javax.management.ObjectName;
import javax.servlet.ServletRequest;
import java.util.Map;

/**
 * @ Author : 苏诗淇
 * @ CreateDate: 2020/4/26 7:47 下午
 * @ Description: 别名绑定
 */
public class ParamAliasDataBinder extends ExtendedServletRequestDataBinder {

    private final Map<String, String> renameMapping;

    public ParamAliasDataBinder(Object target, String objectName,Map<String, String> renameMapping) {
        super(target, objectName);
        this.renameMapping = renameMapping;
    }


    @Override
    protected void addBindValues(MutablePropertyValues mpvs, ServletRequest request) {
        super.addBindValues(mpvs, request);
        for (Map.Entry<String, String> entry : renameMapping.entrySet()){
            // ParamName.value的值,即原请求参数的key没可能和field name不同
            String from = entry.getKey();
            // field name
            String to = entry.getValue();
            if (mpvs.contains(from)){
                // 设置field name 的值,使spring能注入
                mpvs.add(to,mpvs.getPropertyValue(from).getValue());
            }
        }
    }
}

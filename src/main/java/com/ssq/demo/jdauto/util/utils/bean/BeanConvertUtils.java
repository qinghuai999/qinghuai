package com.ssq.demo.jdauto.util.utils.bean;

import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.beans.BeanCopier;
import net.sf.cglib.beans.BeanMap;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
 /**
  * @ Author : 苏诗淇
  * @ CreateDate: 2020/4/26 9:04 下午
  * @ Description: 类拷贝工具
  */
@Slf4j
public class BeanConvertUtils {

    private BeanConvertUtils() {
    }

    private static Lock initLock = new ReentrantLock();
 
    private static Map<String, BeanCopier> beanCopierMap =new HashMap<String,BeanCopier>();
 
    /**
     * 初始化 BeanCopier
     * @param source
     * @param target
     * @return
     */
    private static BeanCopier initCopier(Class source,Class target){
        initLock.lock();
        BeanCopier find = beanCopierMap.get(source.getName()+"_"+target.getName());
        if(find!=null){
            initLock.unlock();
            return find;
        }
        BeanCopier beanCopier = BeanCopier.create(source,target,false);
        beanCopierMap.put(source.getName()+"_"+target.getName(),beanCopier);
        initLock.unlock();
        return beanCopier;
    }
 
 
    /**
     * 获取BeanCopier
     * @param source
     * @param target
     * @return
     */
    private static  BeanCopier getBeanCopier(Class source,Class target){
        BeanCopier beanCopier = beanCopierMap.get(source.getClass().getName()+"_"+target.getName());
        if(beanCopier!=null){
            return beanCopier;
        }
        return initCopier(source,target);
    }
 
 
    /**
     * Pojo 类型转换（浅复制，字段名&类型相同则被复制）
     * @param source
     * @param targetClass
     * @param <T>
     * @return
     */
    public static <T> T convert(Object source, Class<T> targetClass){
        if(source == null){
            return null;
        }
        BeanCopier beanCopier = getBeanCopier(source.getClass(),targetClass);
        try {
            T target = targetClass.newInstance();
            beanCopier.copy(source,target,null);
            return target;
 
        }catch (Exception e){
            log.error("对象拷贝失败");
            log.error(e.getMessage(), e);
            throw new RuntimeException("对象拷贝失败"+source+"_"+targetClass);
        }
    }
 
    /**
     * Pojo 类型转换（浅复制，字段名&类型相同则被复制）
     * @param source
     * @param targetClass
     * @param <E>
     * @return
     */
    public static <E> List<E> convert(List source, Class<E> targetClass){
        if(source==null){
            return null;
        }
        try {
            if(source.isEmpty()){
                return new ArrayList<E>();
            }
            List result = source.getClass().newInstance();
 
            for(Object each: source){
                result.add(convert(each,targetClass));
            }
            return result;
        }catch (Exception e){
            log.error("对象拷贝失败");
            log.error(e.getMessage(), e);
            throw new RuntimeException("对象拷贝失败"+source+"_"+targetClass);
        }
    }

    /**
     * bean转Map
     * @param bean
     * @param <T>
     * @return
     */
    public static <T> Map<Object, Object> beanToMap(T bean) {
        Map<Object, Object> map = Maps.newHashMap();
        if (bean != null) {
            BeanMap beanMap = BeanMap.create(bean);
            for (Object key : beanMap.keySet()) {
                map.put(key, beanMap.get(key));
            }
        }
        return map;
    }

    /**
     * 对象列表转map
     * @param objList
     * @param <T>
     * @return
     */
    public static <T> List<Map<Object, Object>> objectsToMaps(List<T> objList) {
        List<Map<Object, Object>> list = Lists.newArrayList();
        if (objList != null && objList.size() > 0) {
            Map<Object, Object> map = null;
            T bean = null;
            for (int i = 0, size = objList.size(); i < size; i++) {
                bean = objList.get(i);
                map = beanToMap(bean);
                list.add(map);
            }
        }
        return list;
    }
}
package com.ssq.demo.jdauto.util.utils.params;

import org.joda.time.DateTime;

import java.lang.reflect.Field;
import java.util.Date;

/**
 * @author 王守钰
 * @version 1.0
 * @program jdauto-common
 * @date 2020年04月22日 21:16
 * @description: 参数初始化工具
 */
public class ParamsInitUtils {

    private ParamsInitUtils() {
    }

    /**
     * 创建时间
     */
    private static final String[] CREATE_TIMES_PARAMS = {"createTime", "createAt", "createdTime"};

    /**
     * 创建人
     */
    private static final String[] CREATOR_IDS_PARAMS = {"creatorId", "createdBy"};

    /**
     * 更新时间
     */
    private static final String[] UPDATE_TIMES_PARAMS = {"updateTime", "modifyTime", "updateAt", "updatedTime"};

    /**
     * 更新人ID
     */
    private static final String[] UPDATOR_IDS_PARAMS = {"updatorId", "modifierId", "updatedBy"};

    /**
     * 系统操作
     */
    private static final String SYSTEM = "system";


    /**
     * 设置创建时间
     * @param object
     */
    public static void initCreateTime(Object object){
        initParams(object, new Date(), CREATE_TIMES_PARAMS);
    }

    /**
     * 设置创建人
     * @param object
     * @param value
     */
    public static void initCreatorId(Object object, Object value){
        initParams(object, value, CREATOR_IDS_PARAMS);
    }

    /**
     * 初始化创建信息
     * @param object
     * @param value
     */
    public static void initCreateInfo(Object object, Object value){
        initCreateTime(object);
        initCreatorId(object, value);
        initUpdateInfo(object, value);
    }

    /**
     * 设置更新时间
     * @param object
     */
    public static void initUpdateTime(Object object){
        initParams(object, new Date(), UPDATE_TIMES_PARAMS);
    }

    /**
     * 设置更新人
     * @param object
     * @param value
     */
    public static void initUpdatorId(Object object, Object value){
        initParams(object, value, UPDATOR_IDS_PARAMS);
    }

    /**
     * 初始化更新信息
     * @param object
     * @param value
     */
    public static void initUpdateInfo(Object object, Object value){
        initUpdateTime(object);
        initUpdatorId(object, value);
    }

    /**
     * 系统更新
     * @param object
     */
    public static void initSystemUpdateInfo(Object object){
        initUpdateInfo(object, SYSTEM);
    }

    /**
     * 系统创建
     * @param object
     */
    public static void initSystemCreateInfo(Object object){
        initCreateInfo(object, SYSTEM);
    }

    /**
     * 初始化参数
     * @param object
     * @param value
     * @param params
     */
    private static void initParams(Object object, Object value, String ... params){
        Class<?> clazz = object.getClass();
        while (clazz != null){
            for (String param : params){
                try {
                    // 获取该类的成员变量
                    Field field = clazz.getDeclaredField(param);

                    if(null == field){
                        continue;
                    }

                    // 取消语言访问检查
                    field.setAccessible(true);
                    // 获取列类型
                    Class<?> type = field.getType();

                    // Integer
                    if(type.equals(Integer.class) || type.toString().endsWith("int")){
                        // 给变量赋值
                        field.set(object, Integer.valueOf(String.valueOf(value)));
                    }

                    // Double
                    if(type.equals(Double.class) || type.toString().endsWith("double")){
                        // 给变量赋值
                        field.set(object, Double.valueOf(String.valueOf(value)));
                    }

                    // Long
                    if(type.equals(Long.class) || type.toString().endsWith("long")){
                        // 给变量赋值
                        field.set(object, Long.valueOf(String.valueOf(value)));
                    }

                    // Boolean
                    if(type.equals(Boolean.class) || type.toString().endsWith("boolean")){
                        // 给变量赋值
                        field.set(object, Boolean.valueOf(String.valueOf(value)));
                    }

                    // 字符串
                    if(type.equals(String.class)){
                        // 给变量赋值
                        field.set(object, String.valueOf(value));
                    }

                    // 时间
                    if(type.equals(Date.class)){
                        // 给变量赋值
                        field.set(object, new DateTime(value).toDate());
                    }
                }catch (Exception e){
                }
            }
            clazz = clazz.getSuperclass();
        }

    }
}

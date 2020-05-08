package com.ssq.demo.jdauto.dms.system.employee.constant;
/**
 * @Author: 苏诗淇
 * @CreateDate: 2020/5/7 7:53 下午
 * @Description: 员工异常错误码
 */
public class EmployeeErrorCodeConstant {

    /**
     * 添加员工失败,登录名为空
     */
    public static final Integer ADD_LOGIN_NAME_NULL = 1400000;

    /**
     * 添加员工失败,密码为空
     */
    public static final Integer ADD_PASSWORD_NULL = 1400001;

    /**
     * 添加员工失败,姓名为空
     */
    public static final Integer ADD_NAME_NULL = 1400002;

    /**
     * 添加员工失败,员工CODE为空
     */
    public static final Integer ADD_CODE_NULL = 1400003;

    /**
     * 添加员工失败,组织id为空
     */
    public static final Integer ADD_ORGANIZATION_IDS_NULL = 1400004;

    /**
     * 添加员工失败,邮箱为空
     */
    public static final Integer ADD_EMAIL_NULL = 1400005;

    /**
     * 添加员工失败,手机为空
     */
    public static final Integer ADD_MOBILE_NULL = 1400006;

    /**
     * 添加员工失败,登录名已存在
     */
    public static final Integer ADD_LOGIN_NAME_EXIST = 1400007;

    /**
     * 添加员工失败,员工CODE已存在
     */
    public static final Integer ADD_CODE_EXIST = 1400008;

    /**
     * 添加员工失败,邮箱已存在
     */
    public static final Integer ADD_EMAIL_EXIST = 1400009;

    /**
     * 添加员工失败,手机号已存在
     */
    public static final Integer ADD_MOBILE_EXIST = 1400010;



    /**
     * 更新员工失败,id为空
     */
    public static final Integer UPDATE_ID_NULL = 1410000;

    /**
     * 更新员工失败,员工不存在
     */
    public static final Integer UPDATE_EMPLOYEE_NOT_EXIST = 1410001;

    /**
     * 更新失败,登录名已存在
     */
    public static final Integer UPDATE_LOGIN_NAME_EXIST = 1410003;

    /**
     * 更新失败,员工CODE已存在
     */
    public static final Integer UPDATE_CODE_EXIST = 1410004;

    /**
     * 更新失败,邮箱已存在
     */
    public static final Integer UPDATE_EMAIL_EXIST = 1410005;

    /**
     * 更新失败,手机号已存在
     */
    public static final Integer UPDATE_MOBILE_EXIST = 1410006;



    /**
     * 禁用员工失败,id为空
     */
    public static final Integer DISABLED_ID_NULL = 1420000;

    /**
     * 禁用员工失败,员工不存在
     */
    public static final Integer DISABLED_ID_NOT_EXIST = 1420001;



    /**
     * 启用员工失败,id为空
     */
    public static final Integer ENABLED_ID_NULL = 1430000;

    /**
     * 启用员工失败,员工不存在
     */
    public static final Integer ENABLED_ID_NOT_EXIST = 1430001;


    /**
     * 查询员工失败,员工CODE不存在
     */
    public static final Integer FIND_CODE_NULL = 1440000;

    /**
     * 查询员工失败,登录名称不存在
     */
    public static final Integer FIND_LOGIN_NAME_NULL = 1440001;

    /**
     * 查询员工失败,邮箱不存在
     */
    public static final Integer FIND_EMAIL_NULL = 1440002;

    /**
     * 查询员工失败,手机号不存在
     */
    public static final Integer FIND_MOBILE_NULL = 1440003;

    /**
     * 查询员工失败,员工id不存在
     */
    public static final Integer FIND_ID_NULL = 1440004;
}

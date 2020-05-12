package com.ssq.demo.jdauto.dms.system.role.constant;
/**
 * @Author: 苏诗淇
 * @CreateDate: 2020/5/8 9:45 下午
 * @Description: 角色错误码
 */
public class RoleErrorCodeConstant {

    /**
     * 添加角色,角色名称为空
     */
    public static final Integer ADD_ROLE_NAME_NULL = 1200000;

    /**
     * 添加角色,角色CODE为空
     */
    public static final Integer ADD_ROLE_CODE_NULL = 1200001;

    /**
     * 添加角色,角色描述为空
     */
    public static final Integer ADD_ROLE_DESCRIPTION_NULL = 1200002;

    /**
     * 添加角色,角色CODE已存在
     */
    public static final Integer ADD_ROLE_CODE_EXIST = 1200003;



    /**
     * 更新角色,,角色ID为空
     */
    public static final Integer UPDATE_ROLE_ID_NULL = 1210000;

    /**
     * 更新角色,角色ID不存在
     */
    public static final Integer UPDATE_ROLE_ID_NOT_EXIST = 1210001;

    /**
     * 更新角色,角色CODE已存在
     */
    public static final Integer UPDATE_ROLE_CODE_EXIST = 1210002;


    /**
     * 启用角色,角色ID为空
     */
    public static final Integer ENABLE_ROLE_ID_NULL = 1211000;

    /**
     * 启用角色,角色ID不存在
     */
    public static final Integer ENABLE_ROLE_ID_NOT_EXIST = 1211001;


    /**
     * 禁用角色,角色ID为空
     */
    public static final Integer DISABLE_ROLE_ID_NULL = 1212000;

    /**
     * 禁用角色,角色ID不存在
     */
    public static final Integer DISABLE_ROLE_ID_NOT_EXIST = 1212001;



    /**
     * 删除角色,角色ID为空
     */
    public static final Integer DELETE_ROLE_ID_NULL = 1220000;

    /**
     * 删除角色,角色ID不存在
     */
    public static final Integer DELETE_ROLE_ID_NOT_EXIST = 1220001;


    /**
     * 查找角色,角色ID为空
     */
    public static final Integer FIND_ROLE_ID_NULL = 1230000;

    /**
     * 查找角色,角色ID不存在
     */
    public static final Integer FIND_ROLE_ID_NOT_EXIST = 1230001;

    /**
     * 查找角色,角色CODE为空
     */
    public static final Integer FIND_ROLE_CODE_NULL = 1230002;

    /**
     * 查找角色,角色CODE不存在
     */
    public static final Integer FIND_ROLE_CODE_EXIST = 1230003;
}

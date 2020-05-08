package com.ssq.demo.jdauto.dms.system.employee.entity.data;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ssq.demo.jdauto.dms.common.commondata.entity.data.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
/**
 * @Author: 苏诗淇
 * @CreateDate: 2020/5/7 8:38 下午
 * @Description: 员工do
 */
@Data
@ToString
@EqualsAndHashCode
@TableName(value = "sys_employee")
public class EmployeeDO extends BaseDO {

    /**
     * 登录名称
     */
    @TableField(value = "login_name")
    private String loginName;

    /**
     * 员工密码
     */
    @TableField(value = "password")
    private String password;

    /**
     * 员工姓名
     */
    @TableField(value = "name")
    private String name;

    /**
     * 员工编号
     */
    @TableField(value = "code")
    private String code;

    /**
     * 员工类型
     */
    @TableField(value = "type")
    private Integer type;

    /**
     * 是否启用
     */
    @TableField(value = "is_enabled")
    private Boolean isEnabled;

    /**
     * 是否内置
     */
    @TableField(value = "is_build_in")
    private Boolean isBuildIn;

    /**
     * 是否删除
     */
    @TableField(value = "is_deleted")
    private Boolean isDeleted;

    /**
     * 性别
     */
    @TableField(value = "sex")
    private Integer sex;

    /**
     * 邮箱
     */
    @TableField(value = "email")
    private String email;

    /**
     * 手机号
     */
    @TableField(value = "mobile")
    private String mobile;

    /**
     * 组织ids列表
     */
    @TableField(value = "organization_ids")
    private String organizationIds;

    /**
     * 组织名称列表
     */
    @TableField(value = "organization_names")
    private String organizationNames;
}

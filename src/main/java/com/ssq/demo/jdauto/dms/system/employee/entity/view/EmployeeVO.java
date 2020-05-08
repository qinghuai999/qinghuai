package com.ssq.demo.jdauto.dms.system.employee.entity.view;

import com.ssq.demo.jdauto.dms.common.commondata.entity.view.BaseVO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @Author: 苏诗淇
 * @CreateDate: 2020/5/7 8:46 下午
 * @Description: 员工信息
 */
@Data
@ToString
@EqualsAndHashCode
public class EmployeeVO extends BaseVO {
    /**
     * 登录名称
     */
    private String loginName;

    /**
     * 员工姓名
     */
    private String name;

    /**
     * 员工编号
     */
    private String code;

    /**
     * 员工类型
     */
    private Integer type;

    /**
     * 是否启用
     */
    private Boolean isEnabled;

    /**
     * 是否内置
     */
    private Boolean isBuildIn;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 组织ids
     */
    private String organizationIds;

    /**
     * 组织名称列表
     */
    private String organizationNames;
}

package com.ssq.demo.jdauto.dms.system.employee.entity.transfer;

import com.ssq.demo.jdauto.dms.common.commondata.entity.transfer.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

/**
 * @Author: 苏诗淇
 * @CreateDate: 2020/5/7 8:43 下午
 * @Description: 员工DTO
 */
@Data
@ToString
@EqualsAndHashCode
public class EmployeeDTO extends BaseDTO {
    /**
     * 登录名称
     */
    private String loginName;

    /**
     * 员工密码
     */
    private String password;

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
     * 查询参数
     */
    private String queryParam;

    /**
     * 组织id
     */
    private Long organizationId;

    /**
     * 组织id列表
     */
    private List<Long> organizationIds;

    /**
     * 全部组织名称
     */
    private String organizationNamesStr;

    /**
     * 全部组织id
     */
    private String organizationIdsStr;

    /**
     * 仅显示启用状态
     */
    private Boolean onlyShowEnabled;

    /**
     * 角色id
     */
    private Long roleId;

    /**
     * 角色id列表
     */
    private List<Long> roleIds;

    /**
     * 员工id列表
     */
    private List<Long> employeeIds;
}

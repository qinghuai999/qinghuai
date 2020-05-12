package com.ssq.demo.jdauto.dms.system.organization.entity.data;

import com.baomidou.mybatisplus.annotation.TableName;
import com.ssq.demo.jdauto.dms.common.commondata.entity.data.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author 王守钰
 * @program dms
 * @date 2020年04月22日 18:35
 * @description: 组织do
 */
@Data
@ToString
@EqualsAndHashCode
@TableName(value = "sys_organization")
public class OrganizationDO extends BaseDO {
    /**
     * 父类id
     */
    private Long parentId;

    /**
     * 组织code
     */
    private String code;

    /**
     * 组织名称
     */
    private String name;

    /**
     * 排序编号
     */
    private Integer orderNum;

    /**
     * 描述信息
     */
    private String description;

    /**
     * 父类id列表
     * 以,进行分割
     */
    private String parentIds;

    /**
     * 是否启用
     */
    private Boolean isEnabled;

}

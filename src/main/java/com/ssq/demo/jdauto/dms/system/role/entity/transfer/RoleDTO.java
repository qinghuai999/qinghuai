package com.ssq.demo.jdauto.dms.system.role.entity.transfer;

import com.ssq.demo.jdauto.dms.common.commondata.entity.transfer.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

/**
 * @Author: 苏诗淇
 * @CreateDate: 2020/5/8 8:46 下午
 * @Description: 角色信息DTO
 */
@Data
@ToString
@EqualsAndHashCode
public class RoleDTO extends BaseDTO {

    /**
     * 角色名称
     */
    private String name;

    /**
     * 角色code
     */
    private String code;

    /**
     * 角色描述
     */
    private String description;

    /**
     * 是否启用
     */
    private Boolean isEnabled;

    /**
     * 组织id
     */
    private Long organizationId;

    /**
     * 组织id列表
     */
    private List<Long> organizationIds;

}

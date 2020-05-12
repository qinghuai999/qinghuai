package com.ssq.demo.jdauto.dms.system.organization.entity.transfer;

import com.ssq.demo.jdauto.dms.common.commondata.entity.transfer.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author 王守钰
 * @program dms
 * @date 2020年04月22日 20:45
 * @description: 组织dto对象
 */
@Data
@ToString
@EqualsAndHashCode
public class OrganizationDTO extends BaseDTO {

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
     * 是否启用
     */
    private Boolean isEnabled;

}

package com.ssq.demo.jdauto.dms.system.role.entity.view;

import com.ssq.demo.jdauto.dms.common.commondata.entity.view.BaseVO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @Author: 苏诗淇
 * @CreateDate: 2020/5/8 8:53 下午
 * @Description: 角色VO
 */
@Data
@ToString
@EqualsAndHashCode
public class RoleVO extends BaseVO {

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
}

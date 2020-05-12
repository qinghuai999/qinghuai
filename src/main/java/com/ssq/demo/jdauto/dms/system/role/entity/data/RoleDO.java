package com.ssq.demo.jdauto.dms.system.role.entity.data;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ssq.demo.jdauto.dms.common.commondata.entity.data.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @Author: 苏诗淇
 * @CreateDate: 2020/5/8 8:44 下午
 * @Description: 角色信息DO
 */
@Data
@ToString
@EqualsAndHashCode
@TableName(value = "sys_role")
public class RoleDO extends BaseDO {
    /**
     * 角色名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 角色code
     */
    @TableField(value = "code")
    private String code;

    /**
     * 角色描述
     */
    @TableField(value = "description")
    private String description;

    /**
     * 是否启用
     */
    @TableField(value = "is_enabled")
    private Boolean isEnabled;
}

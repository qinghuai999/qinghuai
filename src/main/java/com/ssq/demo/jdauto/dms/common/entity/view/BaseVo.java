package com.ssq.demo.jdauto.dms.common.entity.view;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @ Author : 苏诗淇
 * @ CreateDate: 2020/4/25 10:55 下午
 * @ Description: 基础视图
 */

@Data
@ToString
@EqualsAndHashCode
public class BaseVo implements Serializable {

    /**
     * 主键id
     */
    private Long id;

    /**
     * 创建人
     */
    private String createdBy;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 更新人
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private Date updateTime;
}

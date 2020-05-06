package com.ssq.demo.jdauto.dms.common.commondata.entity.view;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
/**
 * @Author: 苏诗淇
 * @CreateDate: 2020/5/6 9:47 下午
 * @Description: 基础视图
 */
@Data
@ToString
@EqualsAndHashCode
public class BaseVO implements Serializable {

    /**
     * 主键id
     */
    private Long id;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 更新人
     */
    private String updatedBy;

    /**
     * 更新时间
     */
    private Date updatedTime;
}

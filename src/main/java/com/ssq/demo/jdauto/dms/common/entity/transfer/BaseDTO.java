package com.ssq.demo.jdauto.dms.common.entity.transfer;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;

/**
 * @ Author : 苏诗淇
 * @ CreateDate: 2020/4/25 10:47 下午
 * @ Description: 基本传输对象(入参)
 */
@Data
@ToString
@EqualsAndHashCode
public class BaseDTO extends PageInfo{
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
}

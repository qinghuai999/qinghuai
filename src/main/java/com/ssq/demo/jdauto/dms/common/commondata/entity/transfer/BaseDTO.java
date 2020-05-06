package com.ssq.demo.jdauto.dms.common.commondata.entity.transfer;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @Author: 苏诗淇
 * @CreateDate: 2020/5/6 9:47 下午
 * @Description: 基本传输对象
 */
@Data
@ToString
@EqualsAndHashCode
public class BaseDTO extends PageInfo {

    /**
     * 主键id
     */
    private Long id;

    /**
     * 创建人
     */
    private String createdBy;

    /**
     * 更新人
     */
    private String updatedBy;
}

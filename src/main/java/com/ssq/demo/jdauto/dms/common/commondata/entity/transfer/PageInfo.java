package com.ssq.demo.jdauto.dms.common.commondata.entity.transfer;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
/**
 * @Author: 苏诗淇
 * @CreateDate: 2020/5/6 9:47 下午
 * @Description: 分页信息
 */
@Data
@ToString
@EqualsAndHashCode
public class PageInfo implements Serializable {

    /**
     * 当前页码
     */
    private Long current = 1L;

    /**
     * 分页数量
     */
    private Long size = 20L;
}

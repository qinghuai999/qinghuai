package com.ssq.demo.jdauto.dms.common.entity.transfer;

import java.io.Serializable;

/**
 * @ Author : 苏诗淇
 * @ CreateDate: 2020/4/25 10:51 下午
 * @ Description: 分页信息
 */
public class PageInfo implements Serializable {

    /**
     * 当前页码
     */
    private Long current = 1L;

    /**
     * 每页数量
     */
    private Long size = 10L;

}

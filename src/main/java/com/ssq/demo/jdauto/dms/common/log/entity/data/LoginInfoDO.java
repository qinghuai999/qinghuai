package com.ssq.demo.jdauto.dms.common.log.entity.data;

import com.ssq.demo.jdauto.dms.common.commondata.entity.data.BaseDO;
/**
 * @Author: 苏诗淇
 * @CreateDate: 2020/5/6 9:50 下午
 * @Description: 日志记录
 */
public class LoginInfoDO extends BaseDO {

    /**
     * 模块
     */
    private String module;

    /**
     * 参数
     */
    private String params;

    /**
     * 类型
     */
    private Integer type;

    /**
     * 代理类型
     */
    private String agent;

    /**
     * 请求方式
     */
    private String method;

    /**
     * 请求ip
     */
    private String ip;
}

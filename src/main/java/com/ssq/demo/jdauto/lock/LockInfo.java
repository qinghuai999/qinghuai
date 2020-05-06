package com.ssq.demo.jdauto.lock;

import lombok.*;

import java.io.Serializable;
/**
 * @Author: 苏诗淇
 * @CreateDate: 2020/5/2 4:27 下午
 * @Description: 锁信息
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class LockInfo implements Serializable {
    /**
     * 锁名称
     */
    private String lockKey;

    /**
     * 锁值
     */
    private String lockValue;

    /**
     * 过期时间
     */
    private Long expire;

    /**
     * 获取锁超时时间
     */
    private Long acquireTimeout;

    /**
     * 获取锁次数
     */
    private int acquireCount;
}

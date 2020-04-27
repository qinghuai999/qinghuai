package com.ssq.demo.jdauto.util.mvc.response;

import lombok.*;

import java.io.Serializable;
/**
 * @ Author : 苏诗淇
 * @ CreateDate: 2020/4/26 8:34 下午
 * @ Description: 返回响应结果
 */
@Data
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ResponseResult<T> implements Serializable {
    /**
     * 数据
     */
    private T data;

    /**
     * code
     */
    private Long code;

    /**
     * 响应消息
     */
    private String msg;
}

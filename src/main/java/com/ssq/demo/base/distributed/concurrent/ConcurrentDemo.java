package com.ssq.demo.base.distributed.concurrent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author: 苏诗淇
 * @CreateDate: 2023-06-05 12:59:56
 * @Description: JUC包 - CompletableFuture类
 */
public class ConcurrentDemo {
    CompletableFuture<Integer> a = new CompletableFuture<>();
    CyclicBarrier b = new CyclicBarrier(3);
}

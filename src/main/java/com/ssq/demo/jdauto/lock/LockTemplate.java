package com.ssq.demo.jdauto.lock;

import com.ssq.demo.jdauto.lock.executors.LockExecutor;
import com.ssq.demo.jdauto.lock.utils.LockUtils;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;

/**
 * @Author: 苏诗淇
 * @CreateDate: 2020/5/2 4:28 下午
 * @Description: 锁模版
 */

@Slf4j
public class LockTemplate {
    // 获取本机网卡地址和jvmpid
    private static final String PROCESS_ID = LockUtils.getLocalMAC() + LockUtils.getJvmPid();

    @Setter
    private LockExecutor lockExecutor;

    public LockInfo lock(String key, long expire, long timeout) throws Exception{
        Assert.isTrue(timeout > 0, "tryTime must more than 0");
        long start = System.currentTimeMillis();
        int acquireCount = 0;
        String value = PROCESS_ID + Thread.currentThread().getId();
        if (log.isDebugEnabled()){
            log.debug("try start lock, key:{}, value:{}", key, value);
        }
        // 如果上锁时间小于锁过期时间
        while (System.currentTimeMillis() - start < timeout){
            // 加锁成功
            boolean result = lockExecutor.acquire(key, value, acquireCount);
            acquireCount++;
            if (result){
                // 如果加锁成功, 返回值
                return new LockInfo(key, value, expire, timeout, acquireCount);
            }
            Thread.sleep(50);
        }
        log.info("lock failed try {} times", acquireCount);
        return  null;
    }

    public boolean releaseLock(LockInfo lockInfo){
        log.debug("try release lock, key:{}, value:{}", lockInfo.getLockKey(), lockInfo.getLockValue());
        return lockExecutor.releaseLock(lockInfo);
    }
}

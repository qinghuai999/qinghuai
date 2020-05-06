package com.ssq.demo.jdauto.lock.utils;

import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.net.NetworkInterface;

/**
 * @Author: 苏诗淇
 * @CreateDate: 2020/5/2 2:29 下午
 * @Description: 锁工具
 */
public class LockUtils {
    public LockUtils() {
    }

    /**
     * 获取本机网卡地址
     * @return macAddress
     */
    public static String getLocalMAC(){
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            // 获得网络接口对象(网卡),并得到mac地址,mac地址存在于一个byte数组中
            byte[] mac = NetworkInterface.getByInetAddress(inetAddress).getHardwareAddress();
            if (null == mac){
                return "local";
            }

            // 下面代码是把mac地址拼装成String
            StringBuffer buffer = new StringBuffer();
            for (int i = 0; i < mac.length; i++){
                if (i != 0){
                    buffer.append("-");
                }
                // mac[i] & 0xFF 是为了把byte转化为正整数
                String s = Integer.toHexString(mac[i] & 0xFF);
                buffer.append(s.length() == 1 ? 0 + s : s);
            }
            // 把字符串所有小写字母改为大写,成为正规的mac地址并返回
            return buffer.toString().toUpperCase().replaceAll("-", "-");
        } catch (Exception e) {
            throw new IllegalStateException("getLocalMAC error");
        }
    }

    /**
     * 获取jvmPid
     * @return jvmPid
     */
    public static String getJvmPid(){
        String pid = ManagementFactory.getRuntimeMXBean().getName();
        int indexOf = pid.indexOf('@');
        if (indexOf > 0){
            pid = pid.substring(0, indexOf);
            return pid;
        }
        throw new IllegalStateException("ManagementFactory error");
    }
}

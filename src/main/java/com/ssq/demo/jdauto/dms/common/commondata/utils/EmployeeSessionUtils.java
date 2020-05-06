package com.ssq.demo.jdauto.dms.common.commondata.utils;

import com.google.common.base.Strings;
import com.ssq.demo.jdauto.dms.common.commondata.constant.DmsUserConstant;

import javax.servlet.http.HttpServletRequest;
/**
 * @Author: 苏诗淇
 * @CreateDate: 2020/5/6 9:47 下午
 * @Description: 用户session工具类
 */
public class EmployeeSessionUtils {

    private EmployeeSessionUtils() {
    }

    /**
     * 获取员工id
     * @return 员工id
     */
    public static Long getEmployeeId(){
        return DmsUserConstant.SYSTEM_USER_ID;
    }

    /**
     * 返回用户信息json字符串
     * @param request
     * @return
     */
    public static String getCurrentEmployeeString(HttpServletRequest request) {
        try {
            if(request == null){
                return null;
            }
            String userInfo = request.getParameter("gatewayUser");
            if(Strings.isNullOrEmpty(userInfo)) {
                return null;
            }else {
                return userInfo;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}

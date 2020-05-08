package com.ssq.demo.jdauto.dms.system.employee.listener;

import com.ssq.demo.jdauto.dms.system.employee.event.EmployeeAddEvent;
import com.ssq.demo.jdauto.dms.system.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;

import java.util.List;

/**
 * @Author: 苏诗淇
 * @CreateDate: 2020/5/7 10:16 下午
 * @Description: 员工添加监听器
 */
public class EmployeeAddEmployeeListener implements ApplicationListener<EmployeeAddEvent> {

    @Autowired
    private EmployeeService employeeService;

    @Override
    public void onApplicationEvent(EmployeeAddEvent employeeAddEvent) {
        // 员工id
        Long employeeId = employeeAddEvent.getEmployeeId();

        // 组织id
        List<Long> organizationIds = employeeAddEvent.getOrganizationIds();

        // 绑定员工组织关系

    }
}

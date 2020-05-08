package com.ssq.demo.jdauto.dms.system.employee.event;

import lombok.Data;
import org.springframework.context.ApplicationEvent;

import java.util.List;


/**
 * @Author: 苏诗淇
 * @CreateDate: 2020/5/7 10:12 下午
 * @Description: 员工添加事件
 */
@Data
public class EmployeeAddEvent extends ApplicationEvent {

    /**
     * 员工id
     */
    private Long employeeId;

    /**
     * 组织id列表
     */
    private List<Long> organizationIds;


    public EmployeeAddEvent(Object source) {
        super(source);
    }

    // 有参构造
    public EmployeeAddEvent(Object source, Long employeeId, List<Long> organizationIds) {
        super(source);
        this.employeeId = employeeId;
        this.organizationIds = organizationIds;
    }
}

package com.ssq.demo.jdauto.dms.system.employee.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ssq.demo.jdauto.dms.system.employee.entity.transfer.EmployeeDTO;
import com.ssq.demo.jdauto.dms.system.employee.entity.view.EmployeeVO;

/**
 * @Author: 苏诗淇
 * @CreateDate: 2020/5/7 8:51 下午
 * @Description: 员工服务
 */
public interface EmployeeService {
    /**
     * 新增员工信息
     * @param employeeDTO
     * @return 员工信息
     */
    EmployeeVO add(EmployeeDTO employeeDTO);

    /**
     * 通过id更新员工信息
     * @param employeeDTO
     * @return
     */
    EmployeeVO update(EmployeeDTO employeeDTO);


    /**
     * 禁用员工
     * @param employeeId 员工id
     */
    void disabled(Long employeeId);

    /**
     * 启用员工
     * @param employeeId
     */
    void enabled(Long employeeId);


    /**
     * 员工分页(列表)
     * @param employeeDTO
     * @return
     */
    IPage<EmployeeVO> page(EmployeeDTO employeeDTO);


    // ----------------------查询员工具体信息----------------------
    /**
     * 根据id查询员工信息
     * @param id 员工id
     * @return
     */
    EmployeeVO findById(Long id);

    /**
     * 根据code查询员工信息
     * @param code 员工编码
     * @return
     */
    EmployeeVO findByCode(String code);

    /**
     * 根据登录名称查询员工信息
     * @param loginName 登录名
     * @return
     */
    EmployeeVO findByLoginName(String loginName);

    /**
     * 根据邮箱查询员工信息
     * @param email 邮箱
     * @return
     */
    EmployeeVO findByEmail(String email);

    /**
     * 根据手机查询员工信息
     * @param mobile
     * @return
     */
    EmployeeVO findByMobile(String mobile);

    // TODO 初始密码

    // TODO 更新员工组织

}

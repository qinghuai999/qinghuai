package com.ssq.demo.jdauto.dms.system.employee.service.impl;

import com.ssq.demo.DemoApplicationTests;
import com.ssq.demo.jdauto.dms.system.employee.entity.transfer.EmployeeDTO;
import com.ssq.demo.jdauto.dms.system.employee.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceImplTest extends DemoApplicationTests {

    @Autowired
    private EmployeeService employeeService;

    @Test
    void add() {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setLoginName("淇淇");
        employeeDTO.setCode("9991");
        employeeDTO.setName("jiu1");
        employeeDTO.setPassword("1111");
        employeeDTO.setEmail("1@163.com");
        employeeDTO.setMobile("1666");
        employeeService.add(employeeDTO);
    }

    @Test
    void update() {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(100L);
        employeeDTO.setLoginName("淇淇嘛");
        employeeDTO.setCode("91");
        employeeDTO.setEmail("2@163.com");
        employeeDTO.setMobile("1666");
        employeeService.update(employeeDTO);
    }

    @Test
    void disabled() {
        employeeService.disabled(100L);
    }

    @Test
    void enabled() {
        employeeService.enabled(100L);
    }

    @Test
    void page() {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(100L);
        employeeDTO.setLoginName("淇淇嘛");
        employeeService.page(employeeDTO);
    }

    @Test
    void findById() {
    }

    @Test
    void findByCode() {
    }

    @Test
    void findByLoginName() {
    }

    @Test
    void findByEmail() {
    }

    @Test
    void findByMobile() {
    }
}
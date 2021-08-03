package com.ssq.demo.base.aopdemo;

import org.junit.Test;

public class UserServiceImplTest {

    @Test
    public void demo() throws Exception{
        UserService userService = MyBeanFactory.creatService();
        userService.addUser();
        userService.updateUser();
        userService.deleteUser();
    }
}

package com.ssq.demo.base.aopDemo;

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

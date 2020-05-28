package com.ssq.demo.base.aopDemo;
/**
 * @Author: 苏诗淇
 * @CreateDate: 2020/5/26 7:08 下午
 * @Description: 实现
 */
public class UserServiceImpl implements UserService {
    @Override
    public void addUser() {
        System.out.println("add");
    }

    @Override
    public void updateUser() {
        System.out.println("update");
    }

    @Override
    public void deleteUser() {
        System.out.println("delete");
    }
}

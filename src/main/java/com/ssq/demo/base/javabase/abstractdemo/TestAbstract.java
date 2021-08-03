package com.ssq.demo.base.javabase.abstractdemo;

/**
 * @Author: sushiqi
 * @Description:
 * @Date: 3:27 下午 2020/5/15
 *
 * 抽象类 -> 可定义变量,抽象方法及普通方法体
 */
public abstract class TestAbstract {
    private String name;
    private String sex;

    public TestAbstract(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    public TestAbstract() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public abstract void update(Long id);

    public boolean delete(Long id){
        if (null != id){
            System.out.println(name);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(1);
    }
}

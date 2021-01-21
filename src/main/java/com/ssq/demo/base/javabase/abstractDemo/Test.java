package com.ssq.demo.base.javabase.abstractDemo;

public class Test extends TestAbstract {

    @Override
    public void update(Long id) {

    }

    public void jiujiu(){

    }

    public static void main(String[] args) {
        TestAbstract testAbstract = new Test();
        testAbstract.delete(1L);
    }
}

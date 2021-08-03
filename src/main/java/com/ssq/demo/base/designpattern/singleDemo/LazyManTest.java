package com.ssq.demo.base.designpattern.singleDemo;
/**
 * @Author 苏诗淇
 * @Date 2020/6/2 12:34
 * @Description: 设计模式 - 单例模式之懒汉式
 *                         可以通过上锁来保证线程安全
 */
public class LazyManTest implements Runnable{

    // 私有化一个无参构造，防止直接通过new进行实例化
    private LazyManTest() {}

    // volatile不能保证原子性，适用于读多写少的场景
    private static volatile LazyManTest lazyManTest = null;

    // 提供一个外界调用的接口
    public static LazyManTest getInstance(){
        if (lazyManTest == null){
            synchronized (LazyManTest.class){
                if (lazyManTest == null){
                    lazyManTest = new LazyManTest();
                }
            }
        }
        return lazyManTest;
    }

    public static void main(String[] args) {
        LazyManTest LazyManTest = new LazyManTest();
        LazyManTest LazyManTest1 = new LazyManTest();
        Thread thread = new Thread(LazyManTest);
        Thread thread1 = new Thread(LazyManTest1);
        thread.start();
        thread1.start();
    }

    @Override
    public void run() {
        System.out.println(LazyManTest.getInstance());
    }
}

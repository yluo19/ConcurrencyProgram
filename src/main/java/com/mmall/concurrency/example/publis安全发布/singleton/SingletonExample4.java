package com.mmall.concurrency.example.publis安全发布.singleton;


import com.mmall.concurrency.annotation.NotThreadSafe;

/**
 * 懒汉模式 ==> 双重检测机制（不保证线程安全）
 * 单例实例在第一次使用时进行创建
 *
 */

@NotThreadSafe
public class SingletonExample4 {

    //私有的构造函数 (不能通过new不断实例)
    private SingletonExample4() {

    }
    //单例对象
    private static SingletonExample4 instance = null;

    //静态的工厂方法
    public static  SingletonExample4 getInstance() {

        if (instance == null){     //两个线程同时拿到实例时出问题
            synchronized (SingletonExample4.class) {    // 同步锁
                if (instance == null) {
                    instance = new SingletonExample4();

                    // 1。 memory = allocate() 分配对象内存空间
                    // 2。 ctorInstance() 初始化对象
                    // 3。 instance = memory instance指向内存空间

                    // JVM 和 cpu 优化，发生了指令重排

                    // 1。 memory = allocate() 分配对象内存空间
                    // 3。 instance = memory instance指向内存空间
                    // 2。 ctorInstance() 初始化对象

                }
            }
        }
        return instance;
    }
}

package com.mmall.concurrency.example.publis安全发布.singleton;


import com.mmall.concurrency.annotation.ThreadSafe;

/**
 * 懒汉模式 ==> 双重检测机制 + volatile
 * 单例实例在第一次使用时进行创建
 *
 */

@ThreadSafe
public class SingletonExample5 {

    //私有的构造函数 (不能通过new不断实例)
    private SingletonExample5() {

    }
    //单例对象 ：  volatile + 双重检测 保证了线程安全
    private static volatile SingletonExample5 instance = null; //禁止指令重排

    //静态的工厂方法
    public static SingletonExample5 getInstance() {

        if (instance == null){     //两个线程同时拿到实例时出问题  //B
            synchronized (SingletonExample5.class) {    // 同步锁
                if (instance == null) {
                    instance = new SingletonExample5();   //A

                    // 1。 memory = allocate() 分配对象内存空间
                    // 2。 ctorInstance() 初始化对象
                    // 3。 instance = memory instance指向内存空间

                    // JVM 和 cpu 优化，发生了指令重排  =====》 volatile

                }
            }
        }
        return instance;
    }
}

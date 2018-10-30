package com.mmall.concurrency.example.publis安全发布.singleton;


import com.mmall.concurrency.annotation.NotThreadSafe;

/**
 * 懒汉模式
 * 单例实例在第一次使用时进行创建
 */

@NotThreadSafe
public class SingletonExample1 {

    //私有的构造函数 (不能通过new不断实例)
    private SingletonExample1() {

    }
    //单例对象
    private static SingletonExample1 instance = null;

    //静态的工厂方法
    public static SingletonExample1 getInstance() {
        if (instance == null){     //两个线程同时拿到实例时出问题
            instance = new SingletonExample1();
        }
        return instance;
    }
}

package com.mmall.concurrency.example.publis安全发布.singleton;


import com.mmall.concurrency.annotation.ThreadSafe;

/**
 * 饿汉模式
 * 单例实例在类装载使用时进行创建\
 *
 * 性能可能受损： 1。 构造中操作很多  2。没有对实例使用
 */

@ThreadSafe
public class SingletonExample2 {

    String ab;

    //私有的构造函数 (不能通过new不断实例)
    private SingletonExample2() {

    }
    //单例对象
    private static SingletonExample2 instance = new SingletonExample2();

    //静态的工厂方法
    public static SingletonExample2 getInstance() {
        return instance;
    }
}

package com.mmall.concurrency.example.publis安全发布.singleton;


import com.mmall.concurrency.annotation.NotRecommed;
import com.mmall.concurrency.annotation.ThreadSafe;

/**
 * 懒汉模式
 * 单例实例在第一次使用时进行创建
 */

@ThreadSafe
@NotRecommed
public class SingletonExample3 {

    //私有的构造函数 (不能通过new不断实例)
    private SingletonExample3() {

    }
    //单例对象
    private static SingletonExample3 instance = null;

    //静态的工厂方法
    //但是synchornized 会带来性能低下
    public static synchronized SingletonExample3 getInstance() {
        if (instance == null){     //两个线程同时拿到实例时出问题
            instance = new SingletonExample3();
        }
        return instance;
    }
}

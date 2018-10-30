package com.mmall.concurrency.example.publis安全发布.singleton;


import com.mmall.concurrency.annotation.Recommend;
import com.mmall.concurrency.annotation.ThreadSafe;

/**
 * 枚举类来实现安全发布对象
 *
 * 相比懒汉模式， 安全性更容易保证
 * 相比饿汉模式，在实际调用的时候才初始化对象
 *
*/

@ThreadSafe
@Recommend //
public class SingletonExample7 {

    //私有的构造函数 (不能通过new不断实例)
    private SingletonExample7() {

    }

    //静态的工厂方法
    public static SingletonExample7 getInstance() {

        return  Singleton.INSTANCE.getInstance();
    }

    private enum Singleton {
        INSTANCE;

        private SingletonExample7 singleton;

        //JVM保证了枚举类构造器绝对是被调用一次
        Singleton() {
            singleton = new SingletonExample7();
        }

        public SingletonExample7 getInstance() {
            return singleton;
        }

    }


    public static void main(String[] args) {
        System.out.println(getInstance().hashCode());
        System.out.println(getInstance().hashCode());
    }
}

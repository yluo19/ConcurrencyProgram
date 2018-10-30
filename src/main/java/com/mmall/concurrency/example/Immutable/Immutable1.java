package com.mmall.concurrency.example.Immutable;


import com.mmall.concurrency.annotation.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * 不可变对象：
 *
 * 1。 final 实现对象不可变，基本数据类型初始化后不可更改；
 *           引用类型初始化后不可指向别的对象，但可以修改其中的值。
 *
 * 2。 UnmodifiedXXX<>（） ：： 集合类
 *
 * 3。 ImmutableXXX<>（）：： 集合类
 */

@Slf4j
@NotThreadSafe
public class Immutable1 {

    private final static Integer abc = 1;
    public final static String b = "2";
    private final static Map<Integer, Integer> map = new HashMap<>();

    static {
        map.put(1,2);
        map.put(1,2);
        map.put(1,2);

    }

    private void test(final Integer a ){

       // a = 1;
    }

    public static void main(String[] args) throws Exception {

        Class c =  Class.forName("com.mmall.concurrency.example.Immutable.Immutable1");

        Immutable1 i =(Immutable1)c.newInstance();



        System.out.println(c.getField("b"));

        Immutable1 immutable1 = new Immutable1();

        map.put(1,3);

        for (int k : map.keySet()) {

            System.out.println(k);
            System.out.println(map.get(k));
        }
   //     immutable1.b = "3";


    }

}

package com.mmall.concurrency.example.sychronized;

import com.mmall.concurrency.annotation.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
@ThreadSafe
public class Sync_exp2 {

    //修饰一个类
    public  static void test1(int j) {
        synchronized (Sync_exp1.class) {
            for(int i = 0; i < 10; i++)
                log.info("test1 {} - {}", j, i);
        }
    }

    //修饰一个方法
    public static synchronized void test2(int j) {
        for(int i = 0; i < 10; i++)
            log.info("test2 {} - {}", j, i);
    }

    public static void main(String[] args) {

        //Sync_exp2 exp1 = new Sync_exp2();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() ->{
            test2(1);
        });
        executorService.execute(() ->{
            test2(2);
        });
    }

}

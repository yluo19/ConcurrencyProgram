package com.mmall.concurrency.example.ThreadLocal;

public class RequestHolder {

    private  final  static ThreadLocal<Long> requestHolder = new ThreadLocal<>();

    public static void add(Long id){ //请求进入后端处理之前
        requestHolder.set(id);
    }

    public static Long getId(){
        return requestHolder.get();
    }

    public static void remove(){
        requestHolder.remove();
    }

}

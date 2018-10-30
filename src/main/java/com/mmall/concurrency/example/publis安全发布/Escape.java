package com.mmall.concurrency.example.publis安全发布;


import com.mmall.concurrency.annotation.NotRecommed;
import com.mmall.concurrency.annotation.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NotThreadSafe
@NotRecommed
public class Escape {

    private  int thisCanBeEscape = 0;

    public Escape() {

        new InnerClass();

    }
    private class InnerClass{

        public InnerClass() {
            log.info("{}", Escape.this.thisCanBeEscape);
        }
    }

    public  static void main(String[] args){

        new Escape();


    }


}

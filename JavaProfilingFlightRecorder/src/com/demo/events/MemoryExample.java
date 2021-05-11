package com.demo.events;

import java.math.BigDecimal;
import java.sql.SQLOutput;
import java.util.*;

public class MemoryExample {
    private Random random=new Random();
    private List<BigDecimal> list=new ArrayList<>();
    void insertValues(){
        System.out.println(Thread.currentThread().getName()+"Started.....");
        for(int i=0;i<1000000;i++){
            BigDecimal bd=BigDecimal.valueOf(random.nextGaussian());
            list.add(bd);
        }

    }

    void spawnThread() throws InterruptedException{
            for(int i=0;i<100;i++){

                new Thread(this::insertValues,"Mythread"+i).start();
                Thread.sleep(20000);
            }

    }

    public static void main(String[] args) throws InterruptedException {
        MemoryExample memoryExample=new MemoryExample();
        memoryExample.spawnThread();
    }


}

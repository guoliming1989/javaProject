package com.atguigu.com.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

class Mythread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("********come in Callable ");

        try { TimeUnit.SECONDS.sleep(4); } catch (InterruptedException e){ e.printStackTrace(); }

        return 1024;
    }
}

/**
 * @Auther: zhaomo
 * @Date: 2020/2/12 23:59
 * @Description:   多线程中,第三种获得多线程的方式
 *
 *      1.get方法一般请放在最后一行
 */
public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask<Integer> futureTask = new FutureTask(new Mythread());

        new Thread(futureTask,"A").start();
        new Thread(futureTask,"B").start();  //只有一个futureTask  只调用一次

        System.out.println(Thread.currentThread().getName()+"******计算完成");

        System.out.println(futureTask.get());


    }
}

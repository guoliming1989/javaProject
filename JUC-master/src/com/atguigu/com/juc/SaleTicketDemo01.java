package com.atguigu.com.juc;
/**
 * @Auther: zhaomo
 * @Date: 2020/2/10 21:28
 * @Description:  企业级多线程
 */

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Ticket    //资源类 = 实例变量 +实例方法
{
    private int number = 30;
    //List list = new ArrayList();
    Lock lock = new ReentrantLock();

    public void sale()
    {
        lock.lock();
        try {
            if (number > 0)
            {
                System.out.println(Thread.currentThread().getName()+"\t卖出第："+(number--)+"\t还剩下："+number);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
/*
    题目： 三个售票员     卖出       30 张票
    笔记：  如何编程企业级的多线程代码
     固定的编程套路 + 模板是什么 ？


       1  在高内聚低耦合的前提下  ：  线程     操作    资源类
           1.1 ，一言不合，先创建一个资源类

 */

public class SaleTicketDemo01
{
    public static void main(String[] args) {        //主线程，一切程序的入口

        Ticket ticket = new Ticket();

//        @FunctionalInterface
//        public interface Runnable {
//
//            public abstract void run();
//        }

        new Thread(() -> { for (int i = 0; i <=40 ; i++) ticket.sale(); },"A").start();
        new Thread(() -> { for (int i = 0; i <=40 ; i++) ticket.sale(); },"B").start();
        new Thread(() -> { for (int i = 0; i <=40 ; i++) ticket.sale(); },"C").start();



        // Thread（Runnable target，string name) Allocates a  new Thread object.
//        new Thread(() -> { for (int i = 0; i <=40 ; i++) ticket.sale(); },"A").start();
//        new Thread(() -> { for (int i = 0; i <=40 ; i++) ticket.sale(); },"B").start();
//        new Thread(() -> { for (int i = 0; i <=40 ; i++) ticket.sale(); },"C").start();





     /*   new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <=40 ; i++) {
                    ticket.sale();
                }
            }
        }, "A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <=40 ; i++) {
                    ticket.sale();
                }
            }
        }, "B").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <=40 ; i++) {
                    ticket.sale();
                }
            }
        }, "C").start();*/

    }
}

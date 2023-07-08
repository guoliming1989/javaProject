package com.atguigu.com.juc;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: zhaomo
 * @Date: 2020/03/19 22:23
 * @Description:
 */
public class SemaphoreDemo {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);    //模拟资源类,有三个空车位

         for (int i = 1; i <= 6 ; i++) {
                 new Thread(() -> {
                     try {
                         semaphore.acquire();
                         System.out.println(Thread.currentThread().getName()+"\t抢占到了车位");
                         //暂停一会线程
                         try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e){ e.printStackTrace(); }
                         System.out.println(Thread.currentThread().getName()+"\t离开了车位");

                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }finally {
                         semaphore.release();
                     }
                 },String.valueOf(i)).start();
                 }

    }
}

package com.atguigu.com.juc;

import java.util.concurrent.CountDownLatch;

/**
 * @Auther: zhaomo
 * @Date: 2020/03/19 21:44
 * @Description:
 */
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i <= 6 ; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName()+"\t离开教室");
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"\t班长关门走人");
    }

    public static void closeDoor() {
        for (int i = 1; i <= 6 ; i++) {
                    new Thread(() -> {
                        System.out.println(Thread.currentThread().getName()+"\t离开教室");
                    },String.valueOf(i)).start();
                }

        System.out.println(Thread.currentThread().getName()+"\t班长关门走人");
    }
}

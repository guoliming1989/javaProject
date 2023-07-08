package com.atguigu.com.juc;

import java.util.concurrent.CompletableFuture;

/**
 * @Auther: zhaomo
 * @Date: 2020/03/20 20:29
 * @Description:
 *
 *
 *
 *
 */
public class CompletableFutureDemo {
    public static void main(String[] args) throws Exception {


      /*  CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "没有返回  update mysql  OK");

        });
        completableFuture.get();*/


    /*    CompletableFuture<Integer> integerCompletableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "有返回  update mysql  OK");
            return 1024;
        });

        System.out.println(integerCompletableFuture.get());
*/

        //异步回调

        CompletableFuture<Integer> completableFuture2 =CompletableFuture.supplyAsync(() ->{
            System.out.println(Thread.currentThread().getName()+"\t completableFuture2 ");
            int i = 10/0;
            return 2048;
        });

        System.out.println(completableFuture2.whenComplete((t, u) -> {
            System.out.println("-----t=" + t);
            System.out.println("-----u=" + u);
        }).exceptionally(f -> {
            System.out.println("------exception:" + f.getMessage());
            return 444;
        }).get());


    }
}

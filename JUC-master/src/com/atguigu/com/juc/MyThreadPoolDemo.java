package com.atguigu.com.juc;

import java.net.Socket;
import java.util.concurrent.*;

/**
 * @Auther: zhaomo
 * @Date: 2020/03/20 12:31
 * @Description:
 */
public class MyThreadPoolDemo {

    public static void main(String[] args) {

        System.out.println(Runtime.getRuntime().availableProcessors());

        ExecutorService threadPool = new ThreadPoolExecutor(
                2,
                5,
                2L,
                 TimeUnit.SECONDS,
                 new LinkedBlockingQueue<>(3),    //最多线程  最大线程数  + 队列数
                 Executors.defaultThreadFactory(),
                 new ThreadPoolExecutor.DiscardOldestPolicy());
        try
        {
            //模拟有十个顾客来银行办理业务,五个工作人员提供服务
            for (int i = 1; i <= 10 ; i++) {
                threadPool.execute(() ->{
                    System.out.println(Thread.currentThread().getName()+"\t  办理业务");
                });
                //暂停毫秒
              //  try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e){ e.printStackTrace(); }

            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            threadPool.shutdown();
        }
    }





    public static void initPool() {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);    //一池五个工作线程,类似银行五个受理窗口
        ExecutorService threadPool1 = Executors.newSingleThreadExecutor();    //   一池一线程
        ExecutorService threadPool2 = Executors.newCachedThreadPool();    // 一池N个工作线程,类似银行N个受理窗口

        try
        {
            //模拟有十个顾客来银行办理业务,五个工作人员提供服务
            for (int i = 0; i < 10 ; i++) {
                threadPool.execute(() ->{
                    System.out.println(Thread.currentThread().getName()+"\t  办理业务");
                });
                //暂停毫秒
                try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e){ e.printStackTrace(); }

            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            threadPool.shutdown();
        }
    }


}

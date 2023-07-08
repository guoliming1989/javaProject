package com.atguigu.com.juc;

import java.util.Collection;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: zhaomo
 * @Date: 2020/03/20 01:31
 * @Description:
 *      阻塞队列
 *          1   二个数据结构:  栈/队列
 *              1.1   栈       后进先出
 *              1.2   队列      先进先出
 *              1.3   总结
 *
 *
*          2    阻塞队列
 *              2.1 阻塞   必须要阻塞/不得不阻塞
 *
 *
 *         3    how
 */
public class BlockingQueueDemo {

    public static void main(String[] args) throws InterruptedException {

        // List list = new ArrayList();
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        //第一组  超出队列抛异常
        /*System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));

        //System.out.println(blockingQueue.add("x"));


        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());*/

        //第二组  超出队列布尔值
       /* System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        //System.out.println(blockingQueue.offer("x"));

        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());*/


       //第三组   超队列或空队列程序继续等待  不见不散
       /* blockingQueue.put("a");
        blockingQueue.put("b");
        blockingQueue.put("c");
        //blockingQueue.put("d");

        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());*/


        //第四组   过时不候
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("a", 3L, TimeUnit.SECONDS));


    }

}

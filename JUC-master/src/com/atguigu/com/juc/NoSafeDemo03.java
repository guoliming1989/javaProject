package com.atguigu.com.juc;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @Auther: zhaomo
 * @Date: 2020/2/10 22:50
 * @Description:
 *
 * 1    故障现象
 *      java.util.ConcurrentModificationException
 * 2    导致原因
 *      2.1 多线程并发争抢同一个资源类且没有加锁
 *
 * 3    解决方法
 *      3.1 Vector 加了 synchronized重锁 不能使用
 *      3.2 Collections.synchronizedList(new ArrayList<>());
 *      3.3 CopyOnWriteArrayList();
 *
 *
 * 4    优化建议(同样的错误不犯第二次)
 *
 *
 */
public class NoSafeDemo03 {
    public static void main(String[] args) {
        mapNotSafe();

    }

    public static void mapNotSafe() {
        Map<String,String> map =new ConcurrentHashMap<>();
        for (int i = 1; i <= 30 ; i++) {
            new Thread(() -> {
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0,8));
                System.out.println(map);
            },String.valueOf(i)).start();
        }
    }

    public static void setNotSafe() {
        Set<String> set = new CopyOnWriteArraySet<>();

        for (int i = 1; i <= 30 ; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(set);
            },String.valueOf(i)).start();
        }
    }

    public static void listNotSafe() {
        List<String> list = new CopyOnWriteArrayList();//Collections.synchronizedList(new ArrayList<>());   //new ArrayList<>();
        for (int i = 1; i <= 30 ; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
    }
}

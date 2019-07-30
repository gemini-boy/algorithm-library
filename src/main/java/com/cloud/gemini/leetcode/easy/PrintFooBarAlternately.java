package com.cloud.gemini.leetcode.easy;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * 我们提供一个类：
 *
 * class FooBar {
 *   public void foo() {
 *     for (int i = 0; i < n; i++) {
 *       print("foo");
 *     }
 *   }
 *
 *   public void bar() {
 *     for (int i = 0; i < n; i++) {
 *       print("bar");
 *     }
 *   }
 * }
 * 两个不同的线程将会共用一个 FooBar 实例。其中一个线程将会调用 foo() 方法，另一个线程将会调用 bar() 方法。
 *
 * 请设计修改程序，以确保 "foobar" 被输出 n 次。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: n = 1
 * 输出: "foobar"
 * 解释: 这里有两个线程被异步启动。其中一个调用 foo() 方法, 另一个调用 bar() 方法，"foobar" 将被输出一次。
 * 示例 2:
 *
 * 输入: n = 2
 * 输出: "foobarfoobar"
 * 解释: "foobar" 将被输出两次。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/print-foobar-alternately
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * created by fufan on 2019-07-30 10:22
 **/
public class PrintFooBarAlternately {

    private int n;
    private volatile int count = 0;

    public PrintFooBarAlternately(int n) {
        this.n = n;
        count = 2 * n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while(this.count % 2 == 1){
            }
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            count --;
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while(this.count % 2 == 0){
            }
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            count --;
        }
    }
//
//    public static void testlock() {
//        Lock lock = new ReentrantLock();
//        Thread t = new Thread(new Runnable() {
//
//            @Override
//            public void run() {
//                // TODO Auto-generated method stub
//                lock.lock();
//                try {
////                    Thread.sleep(1000);
//                    System.out.println("goon");
//                } catch (Exception e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                } finally {
//                    lock.unlock();
//                }
//            }
//
//        });
//
//        t.start();
//        System.out.println("start");
//        lock.lock();
//
//        System.out.println("over");
//        lock.unlock();
//    }
    public static void main(String[] args) throws InterruptedException {
        PrintFooBarAlternately fooBar = new PrintFooBarAlternately(10);
        new Thread(() -> {
            try {
                fooBar.foo(() -> {
                    System.out.print("foo");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                fooBar.bar(() -> {
                    System.out.print("bar");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


    }
}

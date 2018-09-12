package com.suweiquan.main;

import java.util.concurrent.locks.ReentrantLock;

/**
 * User: suweiquan
 * Date: 2018-09-05
 */
public class ReentrantLockDemo implements Runnable{

    private  static ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        try{
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " has locked");
            for (int i = 0; i < 10; i++){
                System.out.println("i = " + i);
            }
            System.out.println(Thread.currentThread().getName() +" lock release");
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args){
        ReentrantLockDemo demo = new ReentrantLockDemo();
        Thread t1 = new Thread(demo);
        Thread t2 = new Thread(demo);
        t1.start();
        t2.start();
    }
}

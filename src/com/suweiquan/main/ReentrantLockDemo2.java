package com.suweiquan.main;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * User: suweiquan
 * Date: 2018-09-05
 */
public class ReentrantLockDemo2 implements Runnable{

    private static ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        try {
            if(lock.tryLock(1, TimeUnit.MILLISECONDS)){
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + " get lock success");
            }else{
                System.out.println(Thread.currentThread().getName() + " get lock fail");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            if (lock.isHeldByCurrentThread()){
                lock.unlock();
                System.out.println(Thread.currentThread().getName() + " lock release");
            }
        }
    }

    public static void main(String[] args){
        ReentrantLockDemo2 reentrantLockDemo2 = new ReentrantLockDemo2();
        Thread t1 = new Thread(reentrantLockDemo2);
        t1.setName("t1");
        Thread t2 = new Thread(reentrantLockDemo2);
        t2.setName("t2");
        t1.start();
        t2.start();
    }
}

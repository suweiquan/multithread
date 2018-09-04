package com.suweiquan.main;

public class WaitAndNotifyThread {
    private static boolean isWait = true;
    private static Object o = new Object();
    public static void main(String[] args) throws Exception {
        Thread waitThread = new Thread(new WaitAndNotifyThread.WaitThread());
        waitThread.start();
        Thread.sleep(1000);
        Thread notifyThread = new Thread(new WaitAndNotifyThread.NotifyThread());
        notifyThread.start();
        System.out.println("hello world");
        System.out.println("this is a master-bak branch");
    }

    static class WaitThread implements Runnable{
        @Override
        public void run() {
            synchronized (o){
                while(isWait){
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("wait finished");
            }
            System.out.println("hello world");
        }
    }

    static class NotifyThread implements Runnable{
        @Override
        public void run() {

        }
    }
}

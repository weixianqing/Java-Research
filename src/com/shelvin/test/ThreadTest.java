package com.shelvin.test;

/**
 * Created by shelvin zhou on 2015/1/8.
 */
public class ThreadTest extends Thread
{
    private int threadNo;
    private String lock;

    public ThreadTest(int threadNo, String lock) {
        this.threadNo = threadNo;
        this.lock = lock;
    }

    public static void main(String[] args) throws Exception{
        String lock=new String("lock");
        for (int i = 1; i < 10; i++) {
            new ThreadTest(i,lock).start();
            Thread.sleep(1);
        }
    }

    @Override
    public void run() {
        synchronized (lock)
        {
            for (int i = 1; i < 100; i++) {
                System.out.println("No."+threadNo+":"+i);
            }
        }
    }
}

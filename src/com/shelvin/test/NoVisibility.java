package com.shelvin.test;

/**
 * Created by shelvin zhou on 2015/1/7.
 */
public class NoVisibility
{
    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread
    {
        @Override
        public void run() {
            while (!ready)
            {
                //Thread.yield();
                System.out.println(number);
            }
        }
    }

    public static void main(String[] args) {
        Thread t1=new ReaderThread();
        t1.start();
        Thread t2=new ReaderThread();
        t2.start();
        Thread t3=new ReaderThread();
        t3.start();

        number=42;
        ready=true;
    }
}

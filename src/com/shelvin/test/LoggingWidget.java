package com.shelvin.test;

/**
 * Created by shelvin zhou on 2015/1/8.
 */
public class LoggingWidget extends Widget implements Runnable
{
    public static void main(String[] args) {
        LoggingWidget loggingWidget=new LoggingWidget();
        new Thread(loggingWidget).start();
    }
    public synchronized void doSomething()
    {
        System.out.println("this is child synchronized method.");
        System.out.println(toString()+":calling doSomething");
        super.doSomething();
        System.out.println(super.toString());
    }

    @Override
    public void run() {
        doSomething();
    }
}
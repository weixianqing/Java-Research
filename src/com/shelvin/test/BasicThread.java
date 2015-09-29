package com.shelvin.test;

/**
 * Created by shelvin zhou on 2015/1/7.
 */
public class BasicThread
{
    public static void main(String[] args) {
        Thread thread=new Thread(new LiftOff());
        thread.start();
        System.out.println("waiting for liftoff");
    }
}

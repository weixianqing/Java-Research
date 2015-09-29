package com.shelvin.test;

/**
 * Created by shelvin zhou on 2015/1/7.
 */
public class MoreBasicThread
{
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new LiftOff()).start();
        }

        System.out.println("waiting for liftoff");
    }
}

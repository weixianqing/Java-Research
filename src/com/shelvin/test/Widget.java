package com.shelvin.test;

/**
 * Created by shelvin zhou on 2015/1/8.
 */
public class Widget
{
    public synchronized void doSomething()
    {
        System.out.println("this is base synchronized method.");
        System.out.println(toString()+"calling doSomething");
    }
}

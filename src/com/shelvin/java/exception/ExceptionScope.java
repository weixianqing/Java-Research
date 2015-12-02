package com.shelvin.java.exception;

import java.io.IOException;

/**
 * Created by shelvin on 2015/11/30 10:10.
 */
public class ExceptionScope
{
    public static void main(String[] args)
    {
        try
        {
            start();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void start()
    {
        System.out.println("Java Exception interview question Answers for Programmers");
    }
}

package com.shelvin.test;

/**
 * Created by shelvin zhou on 2015/1/15.
 */
public class ThisEscapeTest
{
    public static void main(String[] args)
    {
        EventSource es = new EventSource();
        es.start();
        while(true)
        {
            new ThisEscape(es);
        }
    }
}

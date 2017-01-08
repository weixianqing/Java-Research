package com.shelvin.study.java.static_info;

/**
 * Created by shelvin on 8/1/17 at 21:15.
 */

public class StaticSingleton
{
    public static void main(String[] args)
    {
        System.out.println(TSingleton.a);
        System.out.println(TSingleton.b);
    }
}

class TSingleton
{
    private static TSingleton tSingleton = new TSingleton();
    public static int a;
    public static int b = 0;

    private TSingleton()
    {
        super();
        a++;
        b++;
    }

    public static TSingleton getInstance()
    {
        return tSingleton;
    }
}

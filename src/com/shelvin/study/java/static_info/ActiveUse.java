package com.shelvin.study.java.static_info;

/**
 * Created by shelvin on 8/1/17 at 20:30.
 */

public class ActiveUse
{
    public static void main(String[] args)
    {
        System.out.println(FatherA.lyj);
    }
}

class FatherA
{
    static
    {
        System.out.println("initialized father");
    }

    public static int var1 = 10;

    public static final String lyj = "hello";
}

class SonA extends FatherA
{
    static
    {
        System.out.println("initialized Son");
    }

    public static int var1 = 20;
}

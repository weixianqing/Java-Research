package com.shelvin.java.initial;

/**
 * Created by shelvin on 2015/11/7.
 */
public class ddcs
{
    public static int b = ddcsb.a;
    public static int a =1;

    public ddcs()
    {

    }

    public static void main(String[] args)
    {
        System.out.println("ddcsb.t="+ddcsb.t);
    }
}

class ddcsb
{
    public static int t = ddcs.a;
    public static int a = 1;
}

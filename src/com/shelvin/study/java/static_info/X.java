package com.shelvin.study.java.static_info;

/**
 * Created by shelvin on 8/1/17 at 16:31.
 */

public class X
{
    Y y = new Y();

    static
    {
        System.out.println("static block of X");
    }

    X()
    {
        System.out.println("initialize X");
    }

    public static void main(String[] args)
    {
        new Z();
    }
}

class Z extends X
{
    Y y = new Y();

    static
    {
        System.out.println("static block of Z");
    }

    Z()
    {
        System.out.println("initialize Z");
    }
}

class Y
{
    Y()
    {
        System.out.println("initialize Y");
    }
}

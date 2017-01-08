package com.shelvin.study.java.static_info;

import java.util.Random;

/**
 * Created by shelvin on 8/1/17 at 17:59.
 */

public class FinalStatic
{
    public static void main(String[] args)
    {
        System.out.println(FSSure.var1);
        System.out.println("----------------------");
        System.out.println(FSUnsure.var2);
    }
}

class FSSure
{
    public static final int var1 = 4 + 4;

    static
    {
        System.out.println("fs sure initialized");
    }
}

class FSUnsure
{
    public static final int var2 = 4 + new Random().nextInt(10);

    static
    {
        System.out.println("fs unsure initialized");
    }
}

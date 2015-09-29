package com.shelvin.test;

/**
 * Created by shelvin zhou on 2015/1/14.
 */
public class StaticTest
{
    static
    {
        _i=20;
    }

    public static int _i=50;

    public static void main(String[] args) {
        System.out.println(_i);
    }
}

class AA
{

    static
    {
        System.out.println("father class static block");
    }

    {
        System.out.println("father class no static block");
    }

    public AA()
    {
        System.out.println("father cosntructor");
    }
}

class BB extends AA
{
    static
    {
        System.out.println("son class static block");
    }

    {
        System.out.println("son class no static block");
    }

    public BB()
    {
        System.out.println("son constructor");
    }
}



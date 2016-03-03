package com.shelvin.study.java.initial;

/**
 * Created by shelvin on 2015/11/7.
 */
public class TestVar
{
    public static int k = 2;
    static
    {
        print("静态");
    }
    public static TestVar t1 = new TestVar("t1");
    public static TestVar t2 = new TestVar("t2");
    public static int i = print("i");
    public static int n = 99;
    public int j = print("j");

    {
        print("构造");
    }

    public TestVar(String str)
    {
        System.out.println((++k) + ":" + str + " i=" + i + " n=" + n);
        ++i;
        ++n;
    }

    public static int print(String str)
    {
        System.out.println((++k) + ":" + str + " i=" + i + " n=" + n);
        ++n;
        return ++i;
    }

    public static void main(String[] args)
    {
        TestVar t = new TestVar("init");
    }
}


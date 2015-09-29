package com.shelvin.test;

/**
 * Created by shelvin zhou on 2015/1/9.
 */
public class ConstructorTest
{
    public static void main(String[] args) {
        new Child();
    }
}

class Base
{
    int num;
    public Base(int x)
    {
        num=x;
        System.out.println("father initial");
    }
}

class Child extends Base
{
    public Child(int y)
    {
        super(y);
        System.out.println("child initial with para constructor");
        //System.out.println("num = "+num);
    }

    public Child()
    {
        this(9);
        System.out.println("child initial without para constructor");
        System.out.println("num = "+num);
    }
}
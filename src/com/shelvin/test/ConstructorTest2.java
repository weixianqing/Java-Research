package com.shelvin.test;

/**
 * Created by shelvin zhou on 2015/1/9.
 */
public class ConstructorTest2
{
    public static void main(String[] args) {
        System.out.println("debug");
        //Son son=new Son();
        Son son=new Son();
        son.show();
//        Father father=new Son();
//        father.show();
    }
}

class Father
{
    public Father()
    {
        show();
    }

    public void show()
    {
        System.out.println("father initial");
    }
}

class Son extends Father
{
    int num=10;

    public Son()
    {

    }

    public void show()
    {
        System.out.println("son initial");
        System.out.println("num = "+num);
    }
}
package com.shelvin.study.java.concurrent;

/**
 * Created by shelvin on 2015/12/3 11:16.
 */
public class MultiStateArgs extends Father
{
//    private String name = "zhou";
//    public int age = 2;

    @Override
    public void printName()
    {
        System.out.println(getName());
    }

    public void printFatherName()
    {
        System.out.println(super.getName());
        super.printName();
    }

    public static void main(String[] args)
    {
        MultiStateArgs mstwa = new MultiStateArgs();
        Father father = new Father();

        System.out.println("initial son value:");
        mstwa.printName();

        System.out.println("modified son value:");
        mstwa.setName("yanjiao");
        mstwa.printName();

        System.out.println("after son.setAge and son.setName modification, father value:");
        mstwa.printFatherName();

        System.out.println("initial father value:");
        father.printName();
    }
}

class Father
{
    private String name = "shelvin";
    //private int age = 2;

    public void printName()
    {
        System.out.println(name);
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}

package com.shelvin.test;

/**
 * Created by shelvin zhou on 2015/1/29.
 */
public class ExtVar
{
    private int wagCount=20;

    public static void main(String[] args)
    {
        Dog dog=new Dog();
        ExtVar extVar=new ExtVar();

        dog.setWagCount(16);
        System.out.println("dog wagCount = "+dog.getWagCount());
        System.out.println("extVar wagCount = "+extVar.getWagCount());

        extVar.setWagCount(10);
        System.out.println("dog wagCount = " + dog.getWagCount());
        System.out.println("extVar wagCount = " + extVar.getWagCount());
    }

    public void sayWag()
    {
        System.out.println("wagCount = "+wagCount);
    }

    public int getWagCount() {
        return wagCount;
    }

    public void setWagCount(int wagCount) {
        this.wagCount = wagCount;
    }
}

class Dog extends ExtVar
{

}

package com.shelvin.study.java.pattern.factory.simplefactory;

/**
 * Created by shelvin on 2015/11/29 14:42.
 */
public class Apple implements Fruit
{
    private int appleAge;

    public int getAppleAge()
    {
        return appleAge;
    }

    public void setAppleAge(int appleAge)
    {
        this.appleAge = appleAge;
    }

    @Override
    public void plant()
    {

    }

    @Override
    public void grow()
    {

    }

    @Override
    public void harvest()
    {

    }
}

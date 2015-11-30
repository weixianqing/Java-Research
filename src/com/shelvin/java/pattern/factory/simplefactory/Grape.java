package com.shelvin.java.pattern.factory.simplefactory;

/**
 * Created by shelvin on 2015/11/29 14:44.
 */
public class Grape implements Fruit
{
    private boolean seedless = false;

    public boolean isSeedless()
    {
        return seedless;
    }

    public void setSeedless(boolean seedless)
    {
        this.seedless = seedless;
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

package com.shelvin.test;

/**
 * Created by shelvin zhou on 2015/1/7.
 */
public class LiftOff implements Runnable
{
    protected int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;

    public LiftOff()
    {

    }

    public String status()
    {
        return "#" + id + "(" +
                (countDown > 0 ? countDown : "liftoff!") + ")";
    }

    @Override
    public void run()
    {
        while (countDown-- > 0)
        {
            System.out.println(status());
            Thread.yield();
        }
    }
}

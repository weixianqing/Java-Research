package com.shelvin.java.concurrent;

/**
 * Created by shelvin on 2015/11/6.
 */
public class MutablePoint
{
    public int x;
    public int y;

    public MutablePoint()
    {
        this.x = 0;
        this.y = 0;
    }

    public MutablePoint(MutablePoint point)
    {
        this.x = point.x;
        this.y = point.y;
    }
}

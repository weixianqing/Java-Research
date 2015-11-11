package com.shelvin.java.concurrent;

/**
 * Created by shelvin on 11/5/1515:47.
 */
public class SafePoint
{
    private int x,y;

    private SafePoint(int[] a)
    {
        this(a[0],a[1]);
    }

    //这个构造函数能在多线程下正常工作吗?想办法测试;如果能保证并发,
    //时怎么实现的?(多个线程同时调用这个构造函数,我感觉时会造成并发问题的)
    //这里私有构造器的目的时什么,和这个公有的构造器有没有关系?
    public SafePoint(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public SafePoint(SafePoint p)
    {
        this(p.get());
    }

    public synchronized int[] get()
    {
        return new int[]{x,y};
    }

    public synchronized void set(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}

package com.shelvin.test;

/**
 * Created by shelvin zhou on 2015/1/15.
 */
import java.util.concurrent.*;

public class EventSource extends Thread
{
    private final BlockingQueue<EventListener> listeners =
            new LinkedBlockingQueue<EventListener>();

    public void run()
    {
        while (true)
        {
            try
            {
                listeners.take().onEvent(null);
            }
            catch (InterruptedException e)
            {
                break;
            }
        }
    }

    public void registerListener(EventListener eventListener)
    {
        listeners.add(eventListener);
    }
}

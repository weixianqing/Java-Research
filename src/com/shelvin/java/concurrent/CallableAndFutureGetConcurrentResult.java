package com.shelvin.java.concurrent;

import java.util.concurrent.*;

/**
 * Created by shelvin on 29/11/15.
 */
public class CallableAndFutureGetConcurrentResult
{
    public static void main(String[] args)
    {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Task task = new Task();
        Future<Integer> future = executorService.submit(task);
        executorService.shutdown();

        try
        {
            Thread.sleep(1000);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        System.out.println("main thread is executing...");

        try
        {
            future.get();
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        } catch (ExecutionException e)
        {
            e.printStackTrace();
        }

        System.out.println("all task is executed.");
    }
}

class Task implements Callable
{

    @Override
    public Object call() throws Exception
    {
        System.out.println("task is executing...");
        Thread.sleep(3000);
        int sum = 0;
        for (int i = 0; i < 1000; i++)
        {
            sum += i;
        }

        return sum;
    }
}

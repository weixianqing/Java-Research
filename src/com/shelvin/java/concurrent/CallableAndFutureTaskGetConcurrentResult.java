package com.shelvin.java.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * Created by shelvin on 2015/11/30 9:05.
 */
public class CallableAndFutureTaskGetConcurrentResult
{
    public static void main(String[] args)
    {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Task task = new Task();
        FutureTask<Integer> futureTask = (FutureTask<Integer>) executorService.submit(task);
        executorService.shutdown();
 //       第二种方式，注意这种方式和第一种方式效果是类似的，只不过一个使用的是ExecutorService，一个使用的是Thread
//        Task task = new Task();
//        FutureTask futureTask = new FutureTask(task);
//        Thread thread = new Thread(futureTask);
//        thread.start();

        System.out.println("main thread is executing...");
        try
        {
            Thread.sleep(3000);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        try
        {
            System.out.println("task result:"+futureTask.get());
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

package com.shelvin.java.lock;

/**
 * Created by shelvin zhou on 2014/12/31.
 * 验证内部锁可重入时的锁对象
 */
public class Sync {

    public synchronized static void doSomething(String name) throws InterruptedException{
        System.out.println(name + " super.doSomething, will sleep 10s");
        Thread.sleep(10000);
        System.out.println(name + " wake up");
    }

    public synchronized static void test(String name){
        System.out.println(name + " super.test");
    }

    public static void main(String[] args) throws InterruptedException{
        final SubSync sub = new SubSync();
        Thread t1 = new Thread(new Task(sub,"t1"));
        Thread t2 = new Thread(new Runnable(){

            @Override
            public void run() {
                try {
                    Sync.doSomething("t2");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });
        t1.start();
        t2.start();
    }

}

class Task implements Runnable{

    private SubSync sync;

    private String name;

    public Task(SubSync sync,String name){
        this.sync = sync;
        this.name = name;
    }

    @Override
    public void run() {

        try {
            System.out.println(name + " stated.");
            sync.doSomething2(name);
            System.out.println(name + " finished.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

class SubSync extends Sync{
    public synchronized void doSomething2(String name) throws InterruptedException{
        System.out.println(name + " sub.doSomething2");
        doSomething(name);
    }
}

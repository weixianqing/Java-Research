package com.shelvin.study.java.pattern.observe;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by shelvin on 2015/11/10 10:21.
 */
class Boss extends Observable
{
    private String name;
    private String state;

    public Boss(String name, String state)
    {
        this.name = name;
        this.state = state;
    }

    public String getName()
    {
        return name;
    }

    public String getState()
    {
        this.notifyObservers(state);
        System.out.println(getName() + state);
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
        this.setChanged();
        this.notifyObservers(state);
    }
}

//No.1
//开始写代码，使用观察者模式，请构造Guard类
class Guard implements Observer
{
    private String name;

    public Guard(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg)
    {
        Boss boss = (Boss) o;
        System.out.println(this.getName()+"报告"+boss.getName()+boss.getState());
    }
}


//end_code
public class ObserverTest
{
    public static void main(String[] args)
    {
        Boss Boss = new Boss("老板", "在办公室");
        Guard guard = new Guard("前台");
        Boss.addObserver(guard);
        Boss.getState();
        Boss.setState("离开了");
        Boss.setState("回来了");
    }
}







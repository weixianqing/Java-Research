package com.shelvin.study.java.pattern.singleton;

/**
 * Created by shelvin on 2015/11/29 17:22.
 */
public class BasicSingleton
{
    private static final BasicSingleton SINGLETON = new BasicSingleton();
    private BasicSingleton()
    {

    }

    public static BasicSingleton getSingleton()
    {
        return SINGLETON;
    }
}

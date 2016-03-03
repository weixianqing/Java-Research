package com.shelvin.study.java.pattern.singleton;

/**
 * Created by shelvin on 2015/11/29 18:57.
 */
public class LazySingleton
{
    private static LazySingleton  lazySingleton = null;
    private LazySingleton()
    {

    }

    public synchronized LazySingleton getLazySingleton()
    {
        if (lazySingleton == null)
        {
            return new LazySingleton();
        }else
        {
            return lazySingleton;
        }
    }
}

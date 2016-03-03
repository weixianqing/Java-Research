package com.shelvin.study.java.pattern.factory.factorymethod;

import com.shelvin.study.java.pattern.factory.simplefactory.Apple;
import com.shelvin.study.java.pattern.factory.simplefactory.Fruit;

/**
 * Created by shelvin on 2015/11/29 15:28.
 */
public class AppleFactory implements Factory
{
    @Override
    public Fruit factory()
    {
        return new Apple();
    }
}

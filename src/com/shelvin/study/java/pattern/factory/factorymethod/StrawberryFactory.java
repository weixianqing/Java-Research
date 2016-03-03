package com.shelvin.study.java.pattern.factory.factorymethod;

import com.shelvin.study.java.pattern.factory.simplefactory.Fruit;
import com.shelvin.study.java.pattern.factory.simplefactory.Strawberry;

/**
 * Created by shelvin on 2015/11/29 15:30.
 */
public class StrawberryFactory implements Factory
{
    @Override
    public Fruit factory()
    {
        return new Strawberry();
    }
}

package com.shelvin.study.java.pattern.factory.AbstractFactory;

import com.shelvin.study.java.pattern.factory.simplefactory.Fruit;

/**
 * Created by shelvin on 2015/11/29 16:20.
 */
public class SouthFactory implements Factory
{
    public Fruit fruitFactory()
    {
        return new SouthernFruit();
    }

    public Veggie veggieFactory()
    {
        return new SouthernVeggie();
    }
}

package com.shelvin.java.pattern.factory.AbstractFactory;

import com.shelvin.java.pattern.factory.simplefactory.Fruit;

/**
 * Created by shelvin on 2015/11/29 16:18.
 */
public class NorthernFactory implements Factory
{
    public Fruit fruitFactory()
    {
        return new NorthrenFruit();
    }

    public Veggie veggieFactory()
    {
        return new NorthernVeggie();
    }
}

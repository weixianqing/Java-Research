package com.shelvin.java.pattern.factory.simplefactory;

/**
 * Created by shelvin on 2015/11/29 14:40.
 */
public class SimpleFactory
{
    public static Fruit fruitFactory(String fruit) throws BadFruitException
    {
        if (fruit.equalsIgnoreCase("Apple"))
        {
            return  new Apple();
        }
        else if (fruit.equalsIgnoreCase("Grape"))
        {
            return new Grape();
        }
        else if (fruit.equalsIgnoreCase("Strawberry"))
        {
            return new Strawberry();
        }
        else
        {
           throw  new BadFruitException("no nuch fruit.");
        }
    }
}

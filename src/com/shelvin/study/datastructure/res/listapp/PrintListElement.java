package com.shelvin.study.datastructure.res.listapp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by zhousw on 2016/7/17.
 */
public class PrintListElement
{
    public static void main(String[] args)
    {
        int len = 10;
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < len; i++)
        {
            list.add(i*2+1);
        }

        //print list element method 1
        for (int i = 0; i < len; i++)
        {
            System.out.print(list.get(i)+" ");
        }
        System.out.println();

        //print list element method 2
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext())
        {
            System.out.print(iterator.next()+" ");
        }
        System.out.println();

        //print list element method 3
        System.out.println(list);

        //print list element method 3
        for (Integer integer:list)
        {
            System.out.print(integer+" ");
        }
        System.out.println();
    }
}

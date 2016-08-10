package com.shelvin.study.datastructure;

/**
 * Created by Shengwei Zhou on 2016/8/9 at 18:08.
 */
public class Factorial {
    public int factorialNormal(int n)
    {
        if (n <= 2)
        {
            return 1;
        }else
        {
            return factorialNormal(n-1)+factorialNormal(n-2);
        }
    }

    public int factorialTail(int n, int acc1, int acc2)
    {
        if (n < 2)
        {
            return acc1;
        }else
        {
            return factorialTail(n-1,acc2,acc1+acc2);
        }
    }
}

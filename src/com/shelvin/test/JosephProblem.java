package com.shelvin.test;

public class JosephProblem
{
    public static void main(String[] args)
    {
        int total = 50;
        int interval = 3;
        int i, people = 0;
        //No.1
        //开始写代码，求出最后留下来的人
        for (i = 2; i <= total; i++)
        {
            people = (people+interval)%i;
        }
        //end_code
        System.out.println("最后留下来的人是:" + (people + 1));
    }
}

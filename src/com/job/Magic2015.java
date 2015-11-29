package com.job;

import java.util.Scanner;

/**
 * Created by shelvin on 11/18/15 19:58.
 */

public class Magic2015
{
    public static void main(String args[])
    {
        Scanner cin = new Scanner(System.in);
        int N;
        N = cin.nextInt();
        int[] num = new int[N];
        String input = cin.next();
        char[] cinput = input.toCharArray();
        for (int i = 0; i < N; i++)
        {
            num[i] = Integer.parseInt(String.valueOf(cinput[i]));
//            if (cin.hasNext())
//            {
//                num[i] = Integer.parseInt(cin.next());
//            }
        }

//        for (int i = 0; i < N; i++)
//        {
//            System.out.println(num[i]);
//        }
        Magic2015 m = new Magic2015();
        int result = m.shiftNum(num,N);
        System.out.println(result);
    }

    public int shiftNum(int[] num,int N)
    {
        int shiftNum = -1;
        int[] temnum = new int[N];
        for (int i = 0; i < N; i++)
        {
            temnum[i] = num[i];
        }
        for (int i = 0; i < N - 1; i++)
        {
            int temp;
            temp = num[i];
            num[i] = num[i+1];
            num[i+1] = temp;

//            for (int j = 0; j < N; j++)
//            {
//                System.out.print(num[j]+"  ");
//            }
            for (int j = 0; j < N; j++)
            {
                if (num[j] == 2 && num[j+1]==0 && num[j+2]==1 && num[j+3]==5 && j<N-3)
                {
                    shiftNum = i+1;
                    return shiftNum;
                }
            }

            num = temnum;
        }

        return shiftNum;
    }
}

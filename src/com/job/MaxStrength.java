package com.job;

import java.util.Arrays;

/**
 * Created by shelvin on 11/18/15 20:50.
 */

public class MaxStrength
{
    public int[] strength(int N,int[] power)
    {
        int[] maxPower = new int[N];

        for (int i = 1; i <= N; i++)
        {
            int minPower = 0;

            for (int j = 0; j < N; j++)
            {
                for (int k = 1; k < i + 1; k++)
                {
                    int[] temp = new int[j];
                    Arrays.sort(temp);
                    if (temp[k] < minPower)
                    {
                        minPower = temp[k];
                    }
                }

            }
            
            maxPower[i] = minPower;
        }

        return maxPower;
    }
}

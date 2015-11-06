package com.job;

/**
 * Created by shelvin on 2015/9/23.
 */
public class ArgsInput
{
    public static void main(String[] args)
    {
        int[] argSize = new int[args.length];
        for (int i = 0; i < args.length; i++)
        {
            argSize[i] = Integer.parseInt(args[i]);
            System.out.println(argSize[i]);
        }
    }
}

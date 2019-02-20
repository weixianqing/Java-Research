package com.shelvin.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Shelvin
 * @date 2017/3/8
 */
public class ControlPlatformInOut
{
    public static void main(String[] args)
    {
        System.out.println("请输入一维数组，每个元素以单个空格间隔，最后一个元素不要添加空格，直接以回车键结束输入");
        System.out.println("bug01 branch test");
        System.out.println("888888888");
        System.out.println("bug04 branch test");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        try
        {
            input = br.readLine();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        int len = input.length();
        System.out.println("len = "+len);
        int len2 = (len+1)/2;
        int[] com = new int[len2];
        for (int i = 0; i < len2; i++)
        {
            com[i] = Integer.parseInt(String.valueOf(input.charAt(2 * i)));
        }

        for (int i = 0; i < len2; i++)
        {
            System.out.println(com[i]);
        }
   }
}

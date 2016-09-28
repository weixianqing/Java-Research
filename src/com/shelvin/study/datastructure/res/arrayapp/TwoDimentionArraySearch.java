package com.shelvin.study.datastructure.res.arrayapp;

public class TwoDimentionArraySearch
{

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        int[][] num = new int[4][4];
        num[0][0] = 1;
        num[0][1] = 2;
        num[0][2] = 8;
        num[0][3] = 9;
        num[1][0] = 2;
        num[1][1] = 4;
        num[1][2] = 9;
        num[1][3] = 12;
        num[2][0] = 4;
        num[2][1] = 7;
        num[2][2] = 10;
        num[2][3] = 13;
        num[3][0] = 6;
        num[3][1] = 8;
        num[3][2] = 11;
        num[3][3] = 15;

        System.out.println(num.length + " " + num[1].length);
    }


    public boolean Find(int[][] num, int columns, int rows, int number)
    {
        boolean found = false;

        int row = 0;
        int column = 0;


        return found;
    }

}

package leetcode;

import java.util.ArrayList;

/**
 * Created by shelvin on 10/9/16 at 16:29.
 */

public class NQueens_51
{
    public ArrayList<ArrayList<String>> solveNQueens(int n)
    {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        if (n <= 0)
        {
            return result;
        }

        int[] dfsrow = new int[n];
        solveNQueensCore(result, dfsrow, n, 0);
        return result;
    }

    public void solveNQueensCore(ArrayList<ArrayList<String>> result, int[] dfsrow, int n, int row)
    {
        if (row == n)
        {
            ArrayList<String> singleRes = translate2String(dfsrow);
            result.add(singleRes);
            return;
        }

        for (int i = 0; i < n; i++)
        {
            if (isValid(dfsrow, row, i))
            {
                dfsrow[row] = i;
                solveNQueensCore(result, dfsrow, n, row + 1);
                //因为在row行上可能有多个解,当深度优先从row行的底层行返回到row行时,只是完成了
                //位置[row,i]时,底层行可能的解,但是在row行上,位置[row,i+1]等也可能是row的
                //上一行row-1的解,所以此时,在row行上,把dfsrow[row]置零,用于保存row的横向上可能的解.
                dfsrow[row] = 0;
            }
        }
    }

    public ArrayList<String> translate2String(int[] dfsrow)
    {
        ArrayList<String> res = new ArrayList<>();
        for (int i = 0; i < dfsrow.length; i++)
        {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < dfsrow.length; j++)
            {
                if (j == dfsrow[i])
                {
                    stringBuilder.append('Q');
                } else
                {
                    stringBuilder.append('.');
                }
            }

            res.add(stringBuilder.toString());
        }
        return res;
    }

    public boolean isValid(int[] dfsrow, int row, int col)
    {
        for (int i = 0; i < row; i++)
        {
            if (dfsrow[i] == col)
            {
                return false;
            }

            if (Math.abs(row - i) == Math.abs(dfsrow[i] - col))
            {
                return false;
            }
        }

        return true;
    }
}

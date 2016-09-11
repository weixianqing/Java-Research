package leetcode;

/**
 * Created by shelvin on 10/9/16 at 20:26.
 */

public class NQueens_52
{
    public static int ansNum;

    public int totalQueens(int n)
    {
        ansNum = 0;
        int[] dfsrow = new int[n];
        calQueens(dfsrow, n, 0);
        return ansNum;
    }

    public void calQueens(int[] dfsrow, int n, int row)
    {
        if (row == n)
        {
            ansNum++;
            return;
        }

        for (int i = 0; i < n; i++)
        {
            if (isValid(dfsrow, row, i))
            {
                dfsrow[row] = i;
                calQueens(dfsrow, n, row + 1);
                dfsrow[row] = 0;
            }
        }
    }

    public boolean isValid(int[] dfsrow, int row, int col)
    {
        for (int i = 0; i < row; i++)
        {
            if (dfsrow[i] == col)
            {
                return false;
            }

            if (Math.abs(dfsrow[row] - col) == row - i)
            {
                return false;
            }
        }
        return true;
    }
}

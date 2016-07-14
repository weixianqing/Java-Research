package leetcode;

/**
 * Created by zhousw on 2016/7/15.
 */
public class RangeAddition_370
{
    public static void main(String[] args)
    {
        int length = 5;
        int[][] updates = {{1, 3, 2}, {2, 4, 3}, {0, 2, -2}};
        for (int i = 0; i < length; i++)
        {
            System.out.print(getModifiedArray(length,updates)[i]+"  ");
        }
    }

    public static int[] getModifiedArray(int length, int[][] updates)
    {
        int[] res = new int[length];
        for (int i = 0; i < length; i++)
        {
            res[i] = 0;
        }

        int index = updates.length;
        for (int i = 0; i < index; i++)
        {
            int beginIndex = updates[i][0];
            int endIndex = updates[i][1];
            int inc = updates[i][2];

            for (int j = beginIndex; j <= endIndex; j++)
            {
                res[j] = res[j] + inc;
            }
        }

        return res;
    }
}

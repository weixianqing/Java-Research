package leetcode;

/**
 * Created by shelvin on 1/10/16 at 19:23.
 */

public class PalindromePartitionII_132
{
    public int minCut1(String string)
    {
        //f[i] 表示前i个字母，最少可以被分割为多少个回文串
        int len = string.length();
        int[] f = new int[len + 1];
        f[0] = 0;

        boolean[][] isPalindrome = getPalindrome(string);

        for (int i = 0; i <= len; i++)
        {
            f[i] = i - 1;
            for (int j = 0; j < i; j++)
            {
                if (isPalindrome[j][i - 1])
                {
                    f[i] = Math.min(f[i], f[j] + 1);
                }
            }
        }

        return f[len];
    }

    public boolean[][] getPalindrome(String string)
    {
        int len = string.length();
        boolean[][] isPalindrome = new boolean[len][len];

        for (int i = 0; i < len; i++)
        {
            isPalindrome[i][i] = true;
        }

        for (int i = 0; i < len - 1; i++)
        {
            if (string.charAt(i) == string.charAt(i + 1))
            {
                isPalindrome[i][i + 1] = true;
            } else
            {
                isPalindrome[i][i + 1] = false;
            }
        }

        for (int length = 2; length < len; length++)
        {
            for (int i = 0; i + length < len; i++)
            {
                isPalindrome[i][i + length] = isPalindrome[i + 1][i + length - 1] && string.charAt(i) == string.charAt(i + length);
            }
        }

        return isPalindrome;
    }


    //f(i)表示[i, n-1] 之间最小的 cut 数，n 为字符串长度
    public int minCut2(String string)
    {
        int len = string.length();
        boolean[][] isPalindrome = new boolean[len][len];
        int[] f = new int[len];

        for (int i = 0; i <= len; i++)
        {
            f[i] = len - 1 - i;
        }

        for (int i = len - 1; i >= 0; i--)
        {
            for (int j = i; j < len; j++)
            {
                if (string.charAt(i) == string.charAt(j) && (isPalindrome[i + 1][j - 1] || (j - i < 2)))
                {
                    isPalindrome[i][j] = true;
                    f[i] = Math.min(f[i], 1 + f[j + 1]);
                }
            }
        }

        return f[0];
    }
}

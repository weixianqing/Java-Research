package leetcode;

import com.shelvin.test.Widget;

/**
 * Created by shelvin on 11/19/15 23:21.
 */

public class LongestPalindromicSubstring
{
    public static void main(String[] args)
    {
        LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
        String s = "abagjaba";
        String result = lps.longestPalindrome(s);
        System.out.println(result);
    }

    public String longestPalindromeDP(String s)
    {
        int strLen = s.length();
        int longestBegin = 0;
        int maxLen = 0;
        char[] strChar;
        strChar = s.toCharArray();
        boolean[][] palindromeFlag = new boolean[strLen][strLen];
        for (int i = 0; i < strLen; i++)
        {
            palindromeFlag[i][i] = true;
        }

        for (int i = 0; i < strLen - 1; i++)
        {
            if (strChar[i] == strChar[i + 1])
            {
                palindromeFlag[i][i + 1] = true;
                maxLen = 2;
                longestBegin = i;
            }
        }

        for (int len = 3; len <= strLen; len++)
        {
            for (int i = 0; i < strLen - len + 1; i++)
            {
                int j = i + len - 1;
                if (strChar[i] == strChar[j] && palindromeFlag[i + 1][j - 1])
                {
                    palindromeFlag[i][j] = true;
                    maxLen = len;
                    longestBegin = i;
                }
            }
        }

        return s.substring(longestBegin, maxLen);
    }

    public String longestPalindrome(String s)
    {
        String res = "";
        char[] input = s.toCharArray();
        int strLen = input.length;
        boolean[][] flag = new boolean[strLen][strLen];

        for (int i = 0; i < strLen; i++)
        {
            for (int j = 0; j < strLen; j++)
            {
                flag[i][j] = false;
            }
        }

        for (int i = 0; i < strLen; i++)
        {
            flag[i][i] = true;
        }

        for (int i = 0; i < strLen - 1; i++)
        {
            if (input[i] == input[i + 1])
            {
                flag[i][i + 1] = true;
            } else
            {
                flag[i][i + 1] = false;
            }
        }

        for (int i = 0; i < strLen - 2; i++)
        {
            for (int j = i + 2; j < strLen; j++)
            {
                if (this.isPalindromic(input,flag,i,j))
                {
                    if (res.length() < j - i + 1)
                    {
                        res = "";
                        for (int k = i; k < j - i + 1; k++)
                        {
                            res += input[k];
                        }
                    }
                }
            }
        }

        return res;
    }

    public boolean isPalindromic(char[] input, boolean[][] flag, int begin, int end)
    {
        if (begin == end)
        {
            return flag[begin][begin];
        } else
        {
            if ((end - begin) == 1)
            {
                return flag[begin][end];
            } else
            {
                return flag[begin][end] = (input[begin] == input[end] && isPalindromic(input, flag, begin + 1, end - 1));
            }
        }
    }
}


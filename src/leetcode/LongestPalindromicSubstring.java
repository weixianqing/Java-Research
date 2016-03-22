package leetcode;
/**
 * Created by shelvin on 11/19/15 23:21.
 */

public class LongestPalindromicSubstring
{
    public static void main(String[] args)
    {
        LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
        String s = "aoab";
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
            if (strChar[i] == strChar[i+1])
            {
                palindromeFlag[i][i+1] = true;
                maxLen = 2;
                longestBegin = i;
            }
        }

        for (int len = 3; len <= strLen; len++)
        {
            for (int i = 0; i < strLen - len + 1; i++)
            {
                int j = i+len-1;
                if (strChar[i] == strChar[j] && palindromeFlag[i+1][j-1])
                {
                    palindromeFlag[i][j] = true;
                    maxLen = len;
                    longestBegin = i;
                }
            }
        }
        
        return s.substring(longestBegin,maxLen);
    }

    public String longestPalindrome(String s)
    {
        String res = "";
        char[] input = s.toCharArray();
        int strLen = input.length;
        boolean[][] flag = new boolean[strLen][strLen];

        for (int i = 0; i < strLen; i++)
        {
            flag[i][i] = true;
        }

        for (int i = 0; i < strLen-1; i++)
        {
            if (input[i] == input[i+1])
            {
                flag[i][i+1] = true;
            }
            else
            {
                flag[i][i+1] = false;
            }
        }

        for (int i = 0; i < strLen; i++)
        {
            int j = 2;
            while ((j < strLen) && input[i] == input[j] && flag[i + 1][j - 1])
            {
                flag[i][j] = true;
                j++;
            }

            flag[i][j] = false;
            if ((j-i-2) > res.length())
            {
                for (int k = i + 1; k < j - i - 2; k++)
                {
                    res += input[k];
                }
            }
        }

        return res;
    }
}


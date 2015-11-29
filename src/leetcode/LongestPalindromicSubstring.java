package leetcode;

/**
 * Created by shelvin on 11/19/15 23:21.
 */

public class LongestPalindromicSubstring
{
    public static void main(String[] args)
    {
        LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
        String s = "abccba";
        String result = lps.longestPalindrome(s);
        System.out.println(result);
    }

    public String longestPalindrome(String s)
    {
        String result = "";
        String temp = "";

        int i,j;
        int N = s.length();
        char[] chars = s.toCharArray();
        //System.out.println(N);
        for (int k = 1; k <= 2*N-1; k++)
        {
            i = k;
            j = k+1;

            while (i >= 1 && j <=2*N-1 && chars[i] == chars[j])
            {
                i--;
                j++;
            }

            for (int l = k+1; l < j; l++)
            {
                temp = temp+chars[l];
            }

            if (temp.length() > result.length())
            {
                result = temp;
            }
            temp = "";
        }

        return result;
    }
}

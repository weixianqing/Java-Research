package leetcode;

/**
 * Created by shelvin on 14/8/16 at 01:42.
 */

public class ImplementstrStr_28
{
    public static void main(String[] args)
    {
        String haystack = "gwfjliyanjiaoagnq";
        String needle = "liyanjiao";
        System.out.println(strStr(haystack, needle));
    }

    public static int strStr(String haystack, String needle)
    {
        int index = 0;

        if (haystack == null || needle == null)
        {
            return -1;
        }

        if (haystack.length() < needle.length())
        {
            return -1;
        }

        if (haystack.length() == needle.length())
        {
            if (haystack.charAt(0) == needle.charAt(0))
            {
                return 0;
            } else
            {
                return -1;
            }
        }

        for (int i = 0; i < haystack.length() - needle.length() + 1; i++)
        {
            int j;
            for (j = 0; j < needle.length(); j++)
            {
                if (haystack.charAt(i + j) != needle.charAt(j))
                {
                    break;
                }
            }

            if (j == needle.length())
            {
                return i;
            }

        }

        return -1;
    }
}

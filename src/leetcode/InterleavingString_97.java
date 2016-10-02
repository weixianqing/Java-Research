package leetcode;

/**
 * Created by shelvin on 2/10/16 at 00:27.
 */

public class InterleavingString_97
{
    public boolean isInterleaved(String s1, String s2, String s3)
    {
        int len1 = s1.length();
        int len2 = s2.length();
        boolean[][] f = new boolean[len1 + 1][len2 + 1];
        int len3 = s3.length();

        if (len1 + len2 != len3)
        {
            return false;
        }

        f[0][0] = true;

        for (int i = 1; i <= len1; i++)
        {
            if (f[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1))
            {
                f[i][0] = true;
            }
        }

        for (int i = 1; i <= len2; i++)
        {
            if (f[0][i - 1] && s2.charAt(i - 1) == s3.charAt(i - 1))
            {
                f[0][i] = true;
            }
        }

        for (int i = 1; i <= len1; i++)
        {
            for (int j = 1; j <= len2; j++)
            {
                if ((f[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i - 1 + j)) || (f[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1)))
                {
                    f[i][j] = true;
                }
            }
        }

        return f[len1][len2];
    }

    public boolean isInterleavedOptimizedSpace(String s1, String s2, String s3)
    {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();

        if (len1 + len2 != len3)
        {
            return false;
        }

        if (len1 < len2)
        {
            return isInterleavedOptimizedSpace(s2, s1, s3);
        }

        boolean[] f = new boolean[len2 + 1];
        for (int i = 1; i <= len2; i++)
        {
            f[i] = true;
        }

        for (int i = 1; i <= len2; i++)
        {
            f[i] = s2.charAt(i - 1) == s3.charAt(i - 1) && f[i - 1];
        }


        for (int i = 1; i <= len1; i++)
        {
            f[0] = s1.charAt(i - 1) == s3.charAt(i - 1) && f[0];

            for (int j = 1; j <= len2; j++)
            {
                f[j] = ((s1.charAt(i - 1) == s3.charAt(i + j - 1) && f[j]) || (s2.charAt(j - 1) == s3.charAt(i + j - 1) && f[j - 1]));
            }
        }

        return f[len2];
    }
}

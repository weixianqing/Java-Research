package leetcode;

import java.util.Arrays;

/**
 * Created by shelvin on 4/10/16 at 22:28.
 */

public class ScrambleString_87
{
    public boolean isScramble(String s1, String s2)
    {
        int m = s1.length();
        int n = s2.length();

        if (m != n)
        {
            return false;
        }

        if (!isValid(s1, s2))
        {
            return false;
        }

        for (int i = 0; i < n; i++)
        {
            String s11 = s1.substring(0, i);
            String s12 = s1.substring(i, n);
            String s21 = s2.substring(0, i);
            String s22 = s2.substring(i, n);
            String s23 = s2.substring(0, n - i);
            String s24 = s2.substring(n - i, n);

            if (isScramble(s11, s21) && isScramble(s12, s22))
            {
                return true;
            }

            if (isScramble(s11, s23) && isScramble(s12, s24))
            {
                return true;
            }
        }

        return false;
    }

    public boolean isValid(String s1, String s2)
    {
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);

        if (!new String(chars1).equals(new String(chars2)))
        {
            return false;
        }

        return true;
    }
}

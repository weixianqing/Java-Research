package leetcode;

import java.util.HashMap;

/**
 * Created by shelvin on 16/10/16 at 22:51.
 */

public class ScrambleString_87_opt
{
    public boolean isScramble(String s1, String s2)
    {
        HashMap<String, Boolean> dp = new HashMap<>();
        int len1 = s1.length();
        int len2 = s2.length();

        if (len1 != len2)
        {
            return false;
        }

        if (len1 == 0)
        {
            return true;
        }

        if (s1.equals(s2))
        {
            return true;
        }

        if (dp.containsKey(s1 + "#" + s2))
        {
            return dp.get(s1 + "#" + s2);
        }

        for (int i = 1; i < len1; i++)
        {
            String s11 = s1.substring(0, i);
            String s12 = s1.substring(i, len1);
            String s21 = s2.substring(0, i);
            String s22 = s2.substring(i, len1);
            String s23 = s2.substring(0, len1 - i);
            String s24 = s2.substring(len1 - i, len1);

            if (isScramble(s11, s21) && isScramble(s12, s22) || isScramble(s11, s23) && isScramble(s12, s24))
            {
                dp.put(s1 + "#" + s2, true);
                return true;
            }

        }
        dp.put(s1 + "#" + s2, false);
        return false;
    }

    public boolean checkScramble(String s1, int start1, String s2, int start2, int len, int[][][] visit)
    {
        if (visit[start1][start2][len] == 1)
        {
            return true;
        }
        if (visit[start1][start2][len] == -1)
        {
            return false;
        }
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 != len2)
        {
            visit[start1][start2][len] = -1;
            return false;
        }
        if (len1 == 0)
        {
            visit[start1][start2][len] = 1;
            return true;
        }
        if (s1.equals(s2))
        {
            visit[start1][start2][len] = 1;
            return true;
        }

        for (int i = 1; i < len1; i++)
        {
            String s11 = s1.substring(0, i);
            String s12 = s1.substring(i, len1);
            String s21 = s2.substring(0, i);
            String s22 = s2.substring(i, len1);
            String s23 = s2.substring(0, len1 - i);
            String s24 = s2.substring(len1 - i, len1);

            if (checkScramble(s11, start1, s21, start2, i, visit) && checkScramble(s12, start1 + i, s22, start2 + i, len - i, visit))
            {
                visit[start1][start2][len] = 1;
                return true;
            }

            if (checkScramble(s11, start1, s23, start2, i, visit) && checkScramble(s12, start1 + i, s24, start2 + i, len - i, visit))
            {
                visit[start1][start2][len] = 1;
                return true;
            }

        }
        visit[start1][start2][len] = -1;
        return false;
    }

    public boolean isScramble2(String s1, String s2)
    {
        int len = s1.length();
        int[][][] visit = new int[len][len][len + 1];
        return checkScramble(s1, 0, s2, 0, len, visit);
    }
}


package leetcode;

import java.util.HashSet;

/**
 * Created by shelvin on 2015/11/9 21:03.
 */

public class LongestSubstrWithoutRepCharac
{
    public static void main(String[] args)
    {
        LongestSubstrWithoutRepCharac lswrc = new LongestSubstrWithoutRepCharac();
        String s = "dvdf";
        int res = lswrc.lengthOfLongestSubstring(s);
        System.out.println(res);
    }

    public int lengthOfLongestSubstring(String s)
    {
        int maxLen = 0;
        int count = 0;
        char[] ch = s.toCharArray();

        HashSet hs = new HashSet();
        for (int i = 0; i < ch.length; i++)
        {
            if (!hs.contains(ch[i]))
            {
                hs.add(ch[i]);
                count++;
            }else
            {
                if (count > maxLen)
                {
                    maxLen = count;
                }
                count = 0;
                hs.clear();
                hs.add(ch[i]);
                count++;
            }
        }

        if (count > maxLen)
        {
            maxLen = count;
        }
        return maxLen;
    }
}

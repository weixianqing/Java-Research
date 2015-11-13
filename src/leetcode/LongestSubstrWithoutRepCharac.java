package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shelvin on 2015/11/9 21:03.
 */

public class LongestSubstrWithoutRepCharac
{
    public static void main(String[] args)
    {
        LongestSubstrWithoutRepCharac lswrc = new LongestSubstrWithoutRepCharac();
        String s = "abcabcab";
        int res = lswrc.lengthOfLongestSubstring(s);
        System.out.println(res);
    }

    public int lengthOfLongestSubstring(String s)
    {
        int maxLength = 0 ;
        int i = 0;
        int j = 0;
        int count = 0;
        char[] ss = s.toCharArray();
        Map<Character,Integer> flagMap = new HashMap<Character, Integer>();

        while (j < ss.length)
        {
            if (!flagMap.containsKey(ss[j]))
            {
                flagMap.put(ss[j],j);
                count = j-i+1;
                maxLength = Math.max(count,maxLength);
                j++;
            }else
            {
                if (count > maxLength)
                {
                    maxLength = count;
                    count = 0;
                }
                j = i = flagMap.get(ss[j])+1;
                flagMap.clear();
            }
        }

        return maxLength;
    }
}

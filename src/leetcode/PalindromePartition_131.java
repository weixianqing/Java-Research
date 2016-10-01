package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shelvin on 1/10/16 at 21:47.
 */

public class PalindromePartition_131
{
    public List<List<String>> partition(String s)
    {
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();

        helper(res, path, s, 0);

        return res;
    }

    public boolean isPalindrome(String s)
    {
        int begin = 0;
        int end = s.length() - 1;

        while (begin < end)
        {
            if (s.charAt(begin) != s.charAt(end))
            {
                return false;
            }

            begin++;
            end--;
        }

        return true;
    }

    public void helper(List<List<String>> res, List<String> path, String s, int pos)
    {
        if (pos == s.length())
        {
            res.add(new ArrayList<String>(path));
            return;
        }

        for (int i = pos + 1; i < s.length(); i++)
        {
            String prefix = s.substring(pos, i);
            if (!isPalindrome(prefix))
            {
                continue;
            }

            path.add(prefix);
            helper(res, path, s, i);
            path.remove(path.size() - 1);
        }
    }
}

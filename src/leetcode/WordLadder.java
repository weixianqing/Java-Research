package leetcode;

import java.util.*;

/**
 * Created by shelvin on 11/8/16 at 20:59.
 */

public class WordLadder
{
    public int minWordLadder(String start, String end, Set<String> dict)
    {
        if (dict == null)
        {
            return 0;
        }
        if (start.equals(end))
        {
            return 1;
        }

        Queue<String> bfsQueue = new LinkedList<>();
        Set<String> strSet = new HashSet<>();
        int len = 1;
        dict.add(end);
        dict.add(start);
        strSet.add(start);
        bfsQueue.offer(start);

        while (!bfsQueue.isEmpty())
        {
            len++;
            for (int i = 0; i < bfsQueue.size(); i++)
            {
                String curWord = bfsQueue.poll();
                List<String> nextWordsList = getNextWords(curWord, dict);
                for (String nextWord : nextWordsList)
                {
                    if (nextWord.equals(end))
                    {
                        return len;
                    }
                    if (!strSet.contains(nextWord))
                    {
                        bfsQueue.offer(nextWord);
                        strSet.add(nextWord);
                    }
                }
            }
        }

        return 0;
    }

    private List<String> getNextWords(String word, Set<String> dict)
    {
        List<String> resList = new ArrayList<String>();

        for (char c = 'a'; c <= 'z'; c++)
        {
            for (int i = 0; i < word.length(); i++)
            {
                if (c != word.charAt(i))
                {
                    String replace = replace(word, i, c);
                    if (dict.contains(replace))
                    {
                        resList.add(replace);
                    }
                }
            }
        }

        return resList;
    }


    private String replace(String word, int index, char c)
    {
        char[] chars = word.toCharArray();
        chars[index] = c;
        return chars.toString();
    }
}

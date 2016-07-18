package leetcode;

import java.util.*;

/**
 * Created by Shelvin Zhou on 2016/7/18.
 */
public class LetterCombinations_17
{
    public static void main(String[] args)
    {
        String digits = "23";
        List<String> res = letterCombinations(digits);
        Iterator iterator = res.iterator();
        while (iterator.hasNext())
        {
            System.out.print(iterator.next()+" ");
        }
    }
    public static List<String> letterCombinations(String digits)
    {
        List<String> res = new ArrayList<String>();
        Map<Character,char[]> map = new HashMap<Character, char[]>();
        map.put('0',new char[]{});
        map.put('1',new char[]{});
        map.put('2',new char[]{'a','b','c'});
        map.put('3',new char[]{'d','e','f'});
        map.put('4',new char[]{'g','h','i'});
        map.put('5',new char[]{'j','k','l'});
        map.put('6',new char[]{'m','n','o'});
        map.put('7',new char[]{'p','q','r','s'});
        map.put('8',new char[]{'t','u','v'});
        map.put('9',new char[]{'w','x','y','z'});

        if (digits == null || digits.equals(""))
        {
            return res;
        }
        StringBuilder stringBuilder = new StringBuilder();
        combine(map,digits,stringBuilder,res);

        return res;
    }

    //recursion,recursion,recursion
    //Important thing Three times
    public static void combine(Map<Character,char[]> map,String digits,StringBuilder stringBuilder,List<String> res)
    {
        if (stringBuilder.length() == digits.length())
        {
            res.add(stringBuilder.toString());
            return;
        }
        for (char c:map.get(digits.charAt(stringBuilder.length())))
        {
            stringBuilder.append(c);
            combine(map,digits,stringBuilder,res);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
    }
}

package leetcode;

import java.util.Stack;

/**
 * Created by shelvin on 6/8/16 at 01:58.
 */

public class ValidParentheses_20
{
    public boolean isValid(String s)
    {
        Stack<Character> temp = new Stack<Character>();
        for (Character character:s.toCharArray())
        {
            if ("{{(".contains(String.valueOf(character)))
            {
                temp.push(character);
            }else
            {
                if (!temp.isEmpty() && isPair(temp.peek(),character))
                {
                    temp.pop();
                }else
                {
                    return false;
                }
            }
        }

        return temp.isEmpty();
    }

    public boolean isPair(Character c1, Character c2)
    {
        return ((c1 == '{' && c2 == '}') || (c1 == '[' && c2 == ']') || (c1 == '(' && c2 == ')'));
    }
}

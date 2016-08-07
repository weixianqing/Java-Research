package leetcode;

import java.util.ArrayList;

/**
 * Created by shelvin on 5/8/16 at 21:54.
 */

public class GenerateParentheses_22
{
    public static void main(String[] args)
    {
        GenerateParentheses_22 test = new GenerateParentheses_22();
        ArrayList result = test.generateParenthesis(3);
        System.out.println(result);
    }

    public ArrayList<String> generateParenthesis(int n)
    {
        ArrayList<String> result = new ArrayList<String>();
        if (n <= 0)
        {
            return result;
        }
        helper(result, "", n, n);
        return result;
    }

    public void helper(ArrayList<String> result, String paren, int left, int right)
    {
        if (left == 0 && right == 0)
        {
            result.add(paren);
            return;
        }

        if (left > 0)
        {
            helper(result, paren + "(", left - 1, right);
        }

        if (right > 0 && left < right)
        {
            helper(result, paren + ")", left, right - 1);
        }
    }
}

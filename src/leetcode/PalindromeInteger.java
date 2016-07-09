package leetcode;

/**
 * Created by shelvin on 9/7/16.
 */
public class PalindromeInteger
{
    public static void main(String[] args)
    {
        int test = 1;
        System.out.println(isPalindrome(test));
    }

    public static boolean isPalindrome(int ipt)
    {
        Integer input = ipt;
        String temp = input.toString();
        int head = 0;
        int tail = temp.length()-1;
        char[] tempArray = temp.toCharArray();

        if (0 == tail)
        {
            return  true;
        }

        while (head < tail)
        {
            if (tempArray[head] == tempArray[tail])
            {
                head++;
                tail--;
            }else
            {
                return false;
            }
        }

        return true;
    }
}

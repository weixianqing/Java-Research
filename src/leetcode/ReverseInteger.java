package leetcode;

/**
 * Created by shelvin on 2016/1/24 19:56.
 */
public class ReverseInteger
{
    public int reverse(int x)
    {
        int temp = 0;
        if (x >= Integer.MAX_VALUE && x <= Integer.MIN_VALUE)
        {
            return 0;
        }
        while (x != 0)
        {
            temp = temp*10+x%10;
            x /= 10;
        }
        return temp;
    }

    public static void main(String[] args)
    {
        ReverseInteger ri = new ReverseInteger();
        int result = ri.reverse(-987654321);
        System.out.println(result);
    }
}

package leetcode;

/**
 * Created by shelvin on 2016/1/24 19:56.
 */
public class ReverseInteger
{
    /*
    without consider integer overflow
     */
    public int reverse(int input)
    {
        int sum = 0;
        while (input != 0)
        {
            int temp = input % 10;
            sum = sum*10+temp;
            input /= 10;
        }

        return sum;
    }

    public int reverseWithuotOverflow()
    {
        int result = 0;



        return result;
    }

    /*
    Test mod function
    Modding of negative's process.
     */
    public static int negMod(int input)
    {
        int result = 0;
        result = input % (-3);
        return result;
    }

    public static void main(String[] args)
    {
        ReverseInteger ri = new ReverseInteger();
        int sum = ri.reverse(-1233);
        System.out.println(sum);

        int result = negMod(8);
        System.out.println(result);
    }
}

package leetcode;


/**
 * Created by shelvin on 2/6/16.
 */
public class StringToInteger
{
    public static void main(String[] args)
    {
        String test = "1a021aglkj1212j2fqwlkf0";
        System.out.println(myAtoI(test));
    }

    public static int myAtoI(String str)
    {

        String temp = str.trim();
        int len = temp.length();
        StringBuffer sbf = new StringBuffer(len);

        char[] tempChar = temp.toCharArray();

        for (int i = 0; i < len; i++)
        {
            if (Character.isDigit(tempChar[i]))
            {
                sbf.append(tempChar[i]);
            }
        }

        String temRes = sbf.toString();
        if (Integer.parseInt(temRes) > Integer.MAX_VALUE)
        {
            return Integer.MAX_VALUE;
        }else if (Integer.parseInt(temRes) < Integer.MIN_VALUE)
        {
            return Integer.MIN_VALUE;
        }else
        {
            return Integer.parseInt(temRes);
        }
    }
}

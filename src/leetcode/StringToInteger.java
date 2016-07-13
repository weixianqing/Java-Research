package leetcode;


/**
 * Created by shelvin on 2/6/16.
 */
public class StringToInteger
{
    public static void main(String[] args)
    {
        String test = "1321fwrjglwqf";
        System.out.println(AtoI(test));
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
        } else if (Integer.parseInt(temRes) < Integer.MIN_VALUE)
        {
            return Integer.MIN_VALUE;
        } else
        {
            return Integer.parseInt(temRes);
        }
    }

    public static int AtoI(String str)
    {
        if (str == null || str.equals(""))
        {
            return 0;
        }

        String temp = str.trim();
        int len = temp.length();
        if (len == 1)
        {
            if (temp.charAt(0) > '0' && temp.charAt(0) < '9')
            {
                return Integer.parseInt(temp);
            }else
            {
                return 0;
            }
        }

        //do not use int to store a integer that maybe bigger than integer's MAX_VALUE
        double res = 0;
        int index = 0;
        boolean sign = false;
        if (temp.charAt(0) == '+')
        {
            index = 1;
            sign = true;
        }else if (temp.charAt(0) == '-')
        {
            index = 1;
        }

        for (; index < len; index++)
        {
            if (temp.charAt(index) < '0' || temp.charAt(index) > '9')
            {
                break;
            }

            if (sign)
            {
                res = res*10+(temp.charAt(index) - '0');
                if (res>Integer.MAX_VALUE)
                {
                    return 0;
                }
            }else
            {
                res = - (res*10+(temp.charAt(index)-'0'));
                if (res< Integer.MIN_VALUE)
                {
                    return 0;
                }
            }
        }

        return (int)res;
    }
}

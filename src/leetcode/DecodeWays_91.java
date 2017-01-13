package leetcode;

/**
 * Created by shelvin on 10/1/17 at 17:22.
 */

public class DecodeWays_91
{
    public int numOfDecodeWays(String digit)
    {
        if (digit == null || digit.length() == 0)
        {
            return 0;
        }

        int[] dp = new int[digit.length() + 1];
        dp[0] = 1;
        if (isValid(digit.substring(1, 2)))
        {
            dp[1] = 1;
        } else
        {
            dp[1] = 0;
        }

        for (int i = 2; i < digit.length(); i++)
        {
            if (isValid(digit.substring(i - 1, i)))
            {
                dp[i] += dp[i - 1];
            }
            if (isValid(digit.substring(i - 2, i)))
            {
                dp[i] += dp[i - 2];
            }
        }

        return dp[digit.length()];
    }

    public boolean isValid(String s)
    {
        if (s.charAt(0) == '0')
        {
            return false;
        }

        int num = Integer.parseInt(s);

        return num >= 1 && num <= 26;
    }
}

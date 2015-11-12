package leetcode;

/**
 * Created by shelvin on 11/8/15 19:59.
 */

public class SingleNumberSolution
{
    public int singleNumber(int[] nums)
    {
        int result = 0;
        int[] helper = new int[32];

        for (int i = 0; i < 32; i++)
        {
            for (int j = 0; j < nums.length; j++)
            {
                helper[i] += (nums[j] >> i) & 1;
            }

            result |= (helper[i] % 3) << i;
        }

        return result;
    }

    public int singleNumber2(int[] A)
    {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (A == null || A.length == 0)
        {
            return 0;
        }
        int result = A[0];

        for (int i = 1; i < A.length; i++)
        {
            result = result ^ A[i];
        }
        return result;
    }

    public int singleNumber3(int[] nums)
    {
        int ones = 0;
        int twos = 0;
        int threes = 0;

        for (int i = 0; i < nums.length; i++)
        {
            twos |= (ones & nums[i]);
            ones ^= nums[i];
            threes = ones & twos;
            ones &= ~threes;
            twos &= ~threes;
        }

        return ones;
    }

    public static void main(String[] args)
    {
        int[] nums = new int[]{2};
        SingleNumberSolution sns = new SingleNumberSolution();
        int result = sns.singleNumber(nums);
        System.out.println(result);
    }
}

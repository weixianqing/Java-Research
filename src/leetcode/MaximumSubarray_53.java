package leetcode;

/**
 * Created by shelvin on 30/9/16 at 23:12.
 */

public class MaximumSubarray_53
{
    //greedy
    public int maxSubarraySum1(int[] nums)
    {
        int maxRes = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++)
        {
            sum += nums[i];
            maxRes = Math.max(maxRes, sum);
            sum = Math.max(sum, 0);
        }

        return maxRes;
    }

    //dynamic programming
    public int maxSubarraySum2(int[] nums)
    {
        int maxRes = Integer.MIN_VALUE;
        int targetFun;

        for (int i = 0; i < nums.length; i++)
        {
            targetFun = Math.max(maxRes + nums[i], nums[i]);
            maxRes = Math.max(targetFun, maxRes);
        }

        return maxRes;
    }


    //prefix sum
    public int maxSubarraySum3(int[] nums)
    {
        int maxRes = Integer.MIN_VALUE;
        int minPrefixSum = 0;
        int maxPrefixSum = 0;

        for (int i = 0; i < nums.length; i++)
        {
            maxPrefixSum += nums[i];
            maxRes = Math.max(maxPrefixSum - minPrefixSum, maxRes);
            minPrefixSum = Math.min(maxPrefixSum, minPrefixSum);
        }

        return maxRes;
    }
}

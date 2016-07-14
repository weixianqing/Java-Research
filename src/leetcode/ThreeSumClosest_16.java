package leetcode;

import java.util.Arrays;

/**
 * Created by zhousw on 2016/7/14.
 */
public class ThreeSumClosest_16
{
    public static void main(String[] args)
    {
        int[] nums = {-1,2,1,-4};
        int target = 1;
        int res = threeSumClosest(nums,target);
        System.out.println(res);
    }
    public static int threeSumClosest(int[] nums,int target)
    {
        int len = nums.length;
        int diff = 0;
        int minDiff = Integer.MAX_VALUE;
        int[] resSet = new int[3];
        Arrays.sort(nums);
        for (int i = 0; i < len; i++)
        {
            int head = i+1;
            int tail = len-1;

            while (head < tail)
            {
                int temp = nums[i]+nums[head]+nums[tail];
                diff = Math.abs(target-temp);
                if (diff<minDiff)
                {
                    minDiff = diff;
                    resSet[0] = i;
                    resSet[1] = head;
                    resSet[2] = tail;
                }
                head++;
                tail--;
            }
        }

        return nums[resSet[0]]+nums[resSet[1]]+nums[resSet[2]];
    }
}

package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Shelvin Zhou on 2016/7/18.
 */
public class FourSum_18
{
    public static void main(String[] args)
    {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int  target = 0;
        List<List<Integer>> list = fourSum(nums,target);
        for (int i = 0; i < list.size(); i++)
        {
            System.out.println(list.get(i));
        }
    }
    public static List<List<Integer>> fourSum(int[] nums,int target)
    {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int  len = nums.length;
        int  tempTarget1;
        int  tempTarget2;

        for (int i = 0; i < len; i++)
        {
            tempTarget1 = target - nums[i];

            for (int j = i+1; j < len; j++)
            {
                tempTarget2 = tempTarget1 - nums[j];
                int head =  j+1;
                int tail = len-1;

                while (head < tail)
                {
                    if (nums[head] + nums[tail] == tempTarget2)
                    {
                        List<Integer> tempList = new ArrayList<Integer>();
                        tempList.add(nums[i]);
                        tempList.add(nums[j]);
                        tempList.add(nums[head]);
                        tempList.add(nums[tail]);
                        res.add(tempList);
                        head++;
                        tail--;
                    }else if (nums[head] + nums[tail] > tempTarget2)
                    {
                        tail--;
                    }else
                    {
                        head++;
                    }

                }
            }
        }

        return res;
    }
}

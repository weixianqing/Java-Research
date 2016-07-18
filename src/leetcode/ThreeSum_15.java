package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhousw on 2016/7/14.
 */
public class ThreeSum_15
{
    public static void main(String[] args)
    {
        int[] nums ={-1, 0, 1, 2, -1, -4};
        int target = 0;
        List<List<Integer>> res = threeSum(nums,target);
        for (int i = 0; i < res.size(); i++)
        {
            List<Integer> temp = res.get(i);
            for (int j = 0; j < temp.size(); j++)
            {
                System.out.print(temp.get(j)+"  ");
            }
            System.out.println();
        }
    }
    public static List<List<Integer>> threeSum(int[] nums,int target)
    {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int len = nums.length;

        Arrays.sort(nums);
        for (int i = 0; i < len; i++)
        {
            int tempTarget = target - nums[i];
            int head = i+1;
            int tail = len-1;

            while (head < tail)
            {
                if (nums[head] + nums[tail] == tempTarget)
                {
                    List<Integer> storeUnit = new ArrayList<Integer>();
                    storeUnit.add(nums[i]);
                    storeUnit.add(nums[head]);
                    storeUnit.add(nums[tail]);
                    res.add(storeUnit);
                    head++;
                    tail--;
                }else if (nums[head]+nums[tail] > tempTarget)
                {
                    tail--;
                }else
                {
                    head++;
                }
            }
        }

        return res;
    }
}

package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by shelvin on 10/1/17 at 11:44.
 */

public class SubsetsII_90
{
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] nums)
    {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> subset = new ArrayList<>();

        if (nums.length == 0 || nums == null)
        {
            return res;
        }
        Arrays.sort(nums);

        helper(nums, res, subset, 0);

        return res;
    }


    public void helper(int[] nums, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> subset, int startindex)
    {
        res.add(new ArrayList<>(subset));
        for (int i = startindex; i < nums.length; i++)
        {
            if (i != 0 && nums[i] == nums[i - 1] && i > startindex)
            {
                continue;
            }
            subset.add(nums[i]);
            helper(nums, res, subset, i + 1);
            subset.remove(subset.size() - 1);
        }
    }
}

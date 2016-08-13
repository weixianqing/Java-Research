package leetcode;

/**
 * Created by shelvin on 13/8/16 at 23:33.
 */

public class RemoveElement_27
{
    public static void main(String[] args)
    {
        int[] nums = {3, 1, 1, 3, 1, 1, 3};
        int val = 3;
        int res = removeElements(nums, val);
        System.out.println(res);
    }

    public static int removeElements(int[] nums, int val)
    {
        int index = 0;

        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] == val)
            {
                continue;
            }

            nums[index++] = nums[i];
        }

        return index;
    }
}

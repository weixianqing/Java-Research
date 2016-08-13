package leetcode;

/**
 * Created by shelvin on 13/8/16 at 22:09.
 */

public class RemoveDuplicatesFromSortedArray_26
{
    public static void main(String[] args)
    {
        int[] nums = {1, 1, 1, 1, 1, 2, 3, 6, 7, 7, 7, 9};
        int res = removeDuplicates(nums);
        System.out.println(res);
    }

    public static int removeDuplicates(int[] nums)
    {
        int index = 0;

        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] == nums[index])
            {
                continue;
            }

            nums[++index] = nums[i];
        }

        return index + 1;
    }
}

package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by shelvin on 11/7/15.
 */

/**
 * 我的方法:先排序,再逼近
 * 本题要求是返回数组下标,我犯的错误是返回的排序后的数组的下标
 * 我的方法还得再把下标对应的数字检索出来,如果原数组有重复的元素,会非常麻烦
 *
 * 靠谱的方法:hash
 * 我把数组下标做key,数组元素做value,然后就卡在了怎么由value取key上了,
 * 实际上,hash key有唯一性,但value没有唯一性,所以由value取key可以,但是比较麻烦
 * 这里使用hash的技巧的技巧是把数组的元素做key,数组下标做value,这样对本问题是可以的,
 * 因为,本问题假设只有一组解,如果不是只有一组解,这样向hash表中
 * 存放数据时,key(也就是数组元素,数组元素可能重复)可能重复,导致先前的数组索引被覆盖.
 */

public class TwoSumSolution
{
    public int[] twoSum(int[] nums, int target)
    {
        int[] results = new int[]{0,0};

        int leftPtr = 0;
        int rightPtr = nums.length-1;

        //sort nums
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++)
        {
            System.out.print(nums[i]+"  ");
        }

        while (leftPtr <= rightPtr)
        {
            if (nums[leftPtr] >= target)
            {
                System.out.println("no such indices.");
                break;
            }

            if (nums[rightPtr] > target)
            {
                rightPtr--;
            }else
            {
                if ((nums[leftPtr] + nums[rightPtr] > target))
                {
                    rightPtr--;
                }else if ((nums[leftPtr]+nums[rightPtr]) < target)
                {
                    leftPtr++;
                }else
                {
                    results[0] = leftPtr;
                    results[1] = rightPtr;
                    break;
                    //return results;
                }
            }
        }

        return results;
    }

    public int[] twoSumHash(int[] nums, int target)
    {
        int[] results = new int[]{0,0};

        Map<Integer,Integer> hashMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++)
        {
            if (!hashMap.containsKey(target-nums[i]))
            {
                hashMap.put(nums[i],i);
            }else
            {
                int index =  hashMap.get(target-nums[i]);
                if (index > i)
                {
                    results[0] = i+1;
                    results[1] = index+1;
                }else
                {
                    results[0] = index+1;
                    results[1] = i+1;
                }

                break;
            }
        }

        return results;
    }

    public static void main(String[] args)
    {
        TwoSumSolution tss = new TwoSumSolution();
        int[] nums = new int[]{3,2,4};
        int[] results = tss.twoSumHash(nums,6);
        System.out.println();
        System.out.println(results[0]+"  "+results[1]);
    }
}

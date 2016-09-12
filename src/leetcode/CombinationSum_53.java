package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by shelvin on 12/9/16 at 11:24.
 */

public class CombinationSum_53
{
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target)
    {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (candidates == null)
        {
            return result;
        }
        Arrays.sort(candidates);
        ArrayList<Integer> path = new ArrayList<>();
        combinationSumCore(candidates, target, result, 0, path);
        return result;
    }

    public void combinationSumCore(int[] candidates, int target, ArrayList<ArrayList<Integer>> result,
                                   int index, ArrayList<Integer> path)
    {
        if (target == 0)
        {
            result.add(new ArrayList<>(path));
            return;
        }

        if (target < 0)
        {
            return;
        }

        int pre = -1;
        for (int i = index; i < candidates.length; i++)
        {
            if (target < candidates[i])
            {
                break;
            }

            if (pre != -1 && pre == candidates[i])
            {
                continue;
            }

            path.add(candidates[i]);
            combinationSumCore(candidates, target - candidates[i], result, i, path);
            path.remove(path.size() - 1);

            pre = candidates[i];
        }
    }
}

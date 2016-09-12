package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Shelvin Zhou on 2016/9/12 at 13:37.
 */
public class CombinationSumII_40 {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (candidates == null) {
            return result;
        }
        Arrays.sort(candidates);
        ArrayList<Integer> path = new ArrayList<>();
        combinationSumCore(result, path, candidates, 0, target);
        return result;
    }

    public void combinationSumCore(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> path,
                                   int[] candidates, int index, int target) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(path));
            return;
        }

        if (target < 0) {
            return;
        }

        int pre = -1;
        for (int i = index; i < candidates.length; i++) {
            if (pre != -1 && pre == candidates[i]) {
                continue;
            }
            if (target < candidates[i]) {
                break;
            }
            path.add(candidates[i]);
            combinationSumCore(result, path, candidates, i + 1, target - candidates[i]);
            path.remove(path.size() - 1);
            pre = candidates[i];
        }
    }
}

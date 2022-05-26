package leetcode.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合总和II
 *
 * @author keyu
 * @since 2022-05-10 11:23
 **/

public class CombinationSum {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    LinkedList<Integer> list = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates, target, 0, 0);
        return result;
    }

    public void dfs(int[] candidates, int target, int sum, int start) {
        if (sum == target) {
            result.add(new ArrayList<>(list));
            return;
        }
        if (sum > target) return;

        for (int i = start; i < candidates.length; i++) {
            list.addLast(candidates[i]);
            sum += candidates[i];
            dfs(candidates, target, sum, i);
            list.removeLast();
            sum -= candidates[i];
        }
    }
}

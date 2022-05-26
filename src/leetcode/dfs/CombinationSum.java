package leetcode.dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合总和
 * @author keyu
 * @since 2022-03-23 10:57
 **/

public class CombinationSum {
    HashSet<List<Integer>> set = new HashSet<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        LinkedList<Integer> list = new LinkedList<>();
        dfs(candidates, target, 0, list);

        List<List<Integer>> result = new ArrayList<>();
        result.addAll(set);

        return result;
    }

    public void dfs(int[] candidates, int target, int sum, LinkedList<Integer> list) {
        if (sum > target) return;
        if (sum == target) {
            List<Integer> copy = new ArrayList<>();
            copy.addAll(list);
            set.add(copy);
            return;
        }

        for (int i = 0; i < candidates.length; i++) {
            if (candidates[i] > target) continue;
            sum += candidates[i];
            list.addLast(candidates[i]);
            dfs(candidates, target, sum, list);
            list.removeLast();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

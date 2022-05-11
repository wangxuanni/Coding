package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 全排列II
 * @author keyu
 * @since 2022-05-11 16:15
 **/

public class PermuteUnique {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    LinkedList<Integer> list = new LinkedList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] visit = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums, visit);
        return result;
    }

    public void dfs(int[] nums, boolean[] visit) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visit[i]) continue;
            if (i > 0 && nums[i] == nums[i - 1]&&visit[i-1]==false) continue;
            list.addLast(nums[i]);
            visit[i] = true;
            dfs(nums, visit);
            visit[i] = false;
            list.removeLast();
        }
    }
}

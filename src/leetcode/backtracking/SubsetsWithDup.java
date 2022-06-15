package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 子集
 *
 * @author keyu
 * @since 2022-05-11 16:15
 **/

public class SubsetsWithDup {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    LinkedList<Integer> list = new LinkedList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        boolean[] visit = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums, 0, visit);
        return result;
    }

    public void dfs(int[] nums, int start, boolean[] visit) {
        result.add(new ArrayList<>(list));

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            if (visit[i]) continue;
            list.addLast(nums[i]);
            visit[i] = true;
            dfs(nums, i + 1, visit);
            visit[i] = false;
            list.removeLast();
        }


    }
}

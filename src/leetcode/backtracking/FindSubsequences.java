package leetcode.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 递增子序列
 *
 * @author keyu
 * @since 2022-05-12 11:57
 **/

public class FindSubsequences {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    LinkedList<Integer> list = new LinkedList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backtracking(nums, 0);
        return result;
    }

    public void backtracking(int[] nums, int startIndex) {
        if (list.size() >= 2) {
            result.add(new ArrayList<>(list));
        }
        boolean[] used = new boolean[201];
        for (int i = startIndex; i < nums.length; i++) {
            if (!list.isEmpty() && list.getLast() > nums[i]) continue;
            if (used[nums[i] + 100]) continue;
            used[nums[i] + 100] = true;
            list.addLast(nums[i]);
            backtracking(nums, i + 1);
            list.removeLast();
        }
    }
}

package leetcode.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合总和III
 * @author keyu
 * @since 2022-05-10 15:56
 **/

public class CombinationSum3 {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    LinkedList<Integer> list = new LinkedList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(n, k, 1);
        return result;
    }

    public void dfs(int n, int k, int start) {
        if (list.size() == k && 0 == n) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i <= 9; i++) {
            if (n - i < 0) break;
            list.addLast(i);
            n -= i;
            dfs(n, k, i + 1);
            list.removeLast();
            n += i;
        }
    }
}

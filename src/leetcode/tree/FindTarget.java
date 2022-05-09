package leetcode.tree;

import java.util.ArrayList;

/**
 * 两数之和IV
 * time complexity O（n+n）=>O(n)
 * space complexity O(n+n) =>O(n)
 * @author keyu
 * @since 2022-04-28 17:27
 **/

public class FindTarget {
    ArrayList<Integer> list = new ArrayList<Integer>();

    public boolean findTarget(TreeNode root, int k) {
        dfs(root);
        int start = 0;
        int end = list.size() - 1;

        while (start < end) {
            int sum = list.get(start) + list.get(end);
            if (sum == k) {
                return true;
            } else if (sum < k) {
                start++;

            } else {
                end--;
            }
        }
        return false;

    }

    public void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);

    }
}
package leetcode.tree;

/**
 * 二叉搜索树中第K小的元素
 * https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/
 *
 * @author keyu
 * @since 2022-04-27 14:32
 **/

public class KthSmallest {
    int count;

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        return dfs(root);
    }

    public int dfs(TreeNode root) {
        if (root == null) return -1;

        int left = dfs(root.left);
        if (left >= 0) return left;

        count--;
        if (count == 0) return root.val;
        int right = dfs(root.right);

        if (right >= 0) return right;
        return -1;

    }

}
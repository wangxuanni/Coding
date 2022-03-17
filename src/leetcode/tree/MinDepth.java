package leetcode.tree;

/**
 * 二叉树的最小深度
 *
 * @author keyu
 * @since 2022-03-17 17:15
 **/

public class MinDepth {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (left == 0) return right + 1;
        if (right == 0) return left + 1;
        return Math.min(left, right) + 1;

    }
}
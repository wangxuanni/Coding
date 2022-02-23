package offer.tree;

/**
 * 二叉树的深度
 * https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof
 * @author wangxuanni
 * @since 2022-02-23 10:36
 **/
public class MaxDepth {
    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}

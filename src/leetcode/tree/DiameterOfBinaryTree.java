package leetcode.tree;

/**
 * @description:
 * @author: wangxuanni
 * @create: 2020-04-26 11:22
 **/

public class DiameterOfBinaryTree {
    int res;

    public int diameterOfBinaryTree(TreeNode root) {
        res = 1;
        deeth(root);
        return res - 1;
    }

    public int deeth(TreeNode root) {
        if (root == null) return 0;
        int left = deeth(root.left);
        int right = deeth(root.right);
        res = Math.max(res, left + right + 1);
        return Math.max(left, right) + 1;
    }
}
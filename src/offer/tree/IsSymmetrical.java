package offer.tree;

/**
 * 对称二叉树
 * https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/5d412v/
 * @author wangxuanni
 * @since 2022-02-03 18:31
 **/
public class IsSymmetrical {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return f(root.right, root.left);
    }

    boolean f(TreeNode right, TreeNode left) {
        if (right == null && left == null) {
            return true;
        }
        if (right == null || left == null || right.val != left.val) {
            return false;
        }
        return f(left.right, right.left) && f(left.left, right.right);

    }
}
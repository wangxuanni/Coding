package leetcode.tree;

/**
 * 另一棵树的子树
 *
 * @author keyu
 * @since 2022-04-27 11:31
 **/

public class IsSubtree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;

        return check(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean check(TreeNode root, TreeNode subRoot) {
        if (root == null) return subRoot == null;

        if (subRoot == null || root.val != subRoot.val) return false;

        return check(root.left, subRoot.left) && check(root.right, subRoot.right);
    }
}

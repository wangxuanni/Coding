package offer.tree;

/**
 * @author keyu
 * @since 2022-02-23 14:34
 **/

public class IsBalanced {
    public boolean isBalanced(TreeNode root) {

        if (root == null) return true;
        return Math.abs(maxDepth(root.left) - maxDepth(root.right)) < 2
                && isBalanced(root.left) && isBalanced(root.right);
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

}

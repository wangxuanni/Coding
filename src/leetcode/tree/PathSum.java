package leetcode.tree;

/**
 * @description:
 * @author: wangxuanni
 * @create: 2019-10-22 15:18
 **/

public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if(root.left==null&&root.right==null)return root.val==sum;
        return hasPathSum(root.left,sum-root.val)||hasPathSum(root.right,sum-root.val);
    }
}

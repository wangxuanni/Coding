package leetcode.tree;

/**
 * @description:
 * @author: wangxuanni
 * @create: 2020-04-19 17:52
 **/

public class MergeTrees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;
        TreeNode treeNode = new TreeNode(t1.val + t2.val);
        treeNode.left = mergeTrees(t1.left, t1.left);
        treeNode.right = mergeTrees(t1.right, t1.right);
        return treeNode;

    }
}

package leetcode.tree;

/**
 * @description:
 * @author: wangxuanni
 * @create: 2019-10-23 16:25
 **/

public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (p.val<root.val&&q.val<root.val)
            return lowestCommonAncestor(root.left,p,q);
        if (p.val>root.val&&q.val>root.val)
            return lowestCommonAncestor(root.right,p,q);
        return root;
    }
}

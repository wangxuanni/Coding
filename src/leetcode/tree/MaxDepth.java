package leetcode.tree;

import tree.TreeNode;

/**
 * @description:
 * @author: wangxuanni
 * @create: 2019-09-24 09:59
 **/

public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if (root==null)return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
}

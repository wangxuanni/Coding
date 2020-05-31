package leetcode.tree;

/**
 * @description:
 * @author: wangxuanni
 * @create: 2020-04-26 16:55
 **/

public class ConvertBST {
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) return root;
        convertBST(root.right);
        sum +=root.val;
        root.val=sum;
        convertBST(root.left);
        return root;
    }
}

package offer.tree;

/**
 * 二叉树的镜像
 * @author wangxuanni
 * @since 2022-02-23 10:36
 **/
public class Mirror {
    public static void main(String[] args) {
        mirror(null);
    }
    public static TreeNode mirror(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = mirror(root.right);
        root.right = mirror(temp);
        return root;
    }
}

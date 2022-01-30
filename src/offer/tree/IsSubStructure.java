package offer.tree;

/**
 * @author wangxuanni
 * @since 2022-01-04 14:16
 **/

public class IsSubStructure {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null) {
            if (A == null) {
                return true;
            } else {
                return false;
            }
        }
        return fTree(A, B);
    }

    boolean fTree(TreeNode currentANode, TreeNode B) {
        if (currentANode == null) {
            return false;
        }
        boolean a = f(currentANode, B);
        boolean b = fTree(currentANode.left, B);
        boolean c = fTree(currentANode.right, B);
        return a || b || c;
    }

    public boolean f(TreeNode aNode, TreeNode bNode) {
        if (bNode == null) {
            return true;
        }
        if (aNode == null) {
            return false;
        }
        if (aNode.val != bNode.val) {
            return false;
        }
        boolean left = f(aNode.left, bNode.left);
        boolean right = f(aNode.right, bNode.right);
        return left && right;
    }
}

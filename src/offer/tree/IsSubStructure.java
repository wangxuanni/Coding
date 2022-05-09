package offer.tree;

/**
 * 树的子结构
 * @author wangxuanni
 * @since 2022-01-04 14:16
 **/

public class IsSubStructure {


    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null) return B == null;

        /*  A:[-1,3,2,0]B:[]
    测试结果:true
    期望结果:false*/
        if (B == null) return false;

        return check(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    public boolean check(TreeNode A, TreeNode B) {
        if (B == null) return true;

        if (A == null || A.val != B.val) return false;

        return check(A.left, B.left) && check(A.right, B.right);
    }
}

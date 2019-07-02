package tree;

public class IsSymmetrical {
    boolean isSymmetrical(TreeNode pRoot)
    { if(pRoot==null){
        return true;
    }
        return com(pRoot.left,pRoot.right);

    }
    boolean com(TreeNode left,TreeNode right)
    {
        if(left==null){
            return right==null;
        }
        if(right==null)
            return false;
        if(left.val!=right.val)
            return false;
        return com(left.right,right.left)&&com(left.left,right.right);
    }

}

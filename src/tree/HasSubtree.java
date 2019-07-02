package tree;

public class HasSubtree {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean r=false;
        if(root1!=null&&root2!=null){
            if(root1.val==root2.val)r=f(root1,root2);
            if(!r)r=HasSubtree(root1.left,root2);
            if(!r)r=HasSubtree(root1.right,root2);
        }
        return r;
    }
    public boolean f(TreeNode root1,TreeNode root2) {
        //有可能出现1=null但2也=null的情况
        if(root1==null&& root2 != null)return false;
        if(root2==null)return true;
        if(root1.val==root2.val)
            return f(root1.left,root2.left)&&f(root1.right,root2.right);
        return false;
    }
}

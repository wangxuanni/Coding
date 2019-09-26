package interviews.tree;

public class ReConstructBinaryTree {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        return re(pre,0,pre.length-1,in,0,in.length-1);
    }
    public TreeNode re(int [] pre,int starPre,int endPre,int [] in,int starIn,int endIn){
        if(starPre>endPre||starIn>endIn){
            return null;
        }
        int rootVal= pre[starPre];
        TreeNode root=new TreeNode(rootVal);
        for(int i=0;i<=endIn;i++){
            if(in[i]==rootVal){
                root.left=re(pre,starPre+1,starPre+i-starIn,in,starIn,i-1);
                root.right=re(pre,starPre+1+i-starIn,endPre,in,i+1,endIn);
            }
        }
        return root;
    }
}

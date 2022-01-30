package structure.tree;

import leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author zakree
 * @since 2021-06-14 22:38
 **/

public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root==null){return new ArrayList(0);}
        ArrayList result= new ArrayList<Integer>();
        Stack<TreeNode> stack=new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode index= stack.peek();

            if(index.left!=null){
                stack.push(index.left);
            }else{  stack.pop();
                result.add(index.val);
                if(index.right!=null){
                    stack.push(index.right);
                }
            }
        } return result;
    }
}

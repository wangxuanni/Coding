package structure.tree;

import leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author zakree
 * @since 2021-06-14 22:39
 **/

public class PostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root==null){return new ArrayList(0);}
        ArrayList result= new ArrayList<Integer>();
        Stack<TreeNode> stack=new Stack<TreeNode>();
        Stack<TreeNode> resultStack=new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode index= stack.pop();
            resultStack.push(index);
            if(index.left!=null){
                stack.push(index.left);
            }
            if(index.right!=null){
                stack.push(index.right);
            }
        }
        while(!resultStack.isEmpty()){
            result.add(resultStack.pop().val);
        }
        return result;
    }
}

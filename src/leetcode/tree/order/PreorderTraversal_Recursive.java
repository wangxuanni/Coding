package leetcode.tree.order;

import offer.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @description:
 * @author: wangxuanni
 * @create: 2019-09-18 23:53
 **/

public class PreorderTraversal_Recursive {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack <TreeNode> stack = new Stack<>();

        if (root==null)return list;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node=stack.pop();
            if (node.right!=null)stack.push(node.right);

            if (node.left!=null) stack.push(node.left);

            list.add(node.val);

        }

        return list;
    }

}

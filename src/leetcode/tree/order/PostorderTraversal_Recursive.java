package leetcode.tree.order;

import interviews.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @description:
 * @author: wangxuanni
 * @create: 2019-09-18 23:51
 **/

public class PostorderTraversal_Recursive {
    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<>();

        if (root == null) return list;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);

            list.add(node.val);
        }
        List<Integer> reserveList = new ArrayList<Integer>();
        for (int i = list.size()-1; i >=0; i--) {
            reserveList.add(list.get(i));

        }
        return reserveList;}
}

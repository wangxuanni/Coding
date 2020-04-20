package leetcode.tree.order;

import offer.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @description:
 * @author: wangxuanni
 * @create: 2019-09-18 23:47
 **/

public class InorderTraversal_Recursive {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        //注意! stack.push(root);
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur=cur.left;
            }
            TreeNode t =  stack.pop();
            list.add(t.val);
            cur=t.right;

        }
        return list;
    }
}

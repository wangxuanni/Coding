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
        //如果它的左孩子为空，就出它，然后把它的右孩子压进栈
        List<Integer> list = new ArrayList<Integer>();
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(cur);

        while (cur == null && stack.isEmpty()) {
            while (cur.left != null) {
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

package leetcode.tree.order;

import tree.TreeNode;

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
        List<Integer> ret = new ArrayList<>();
        if (root == null) return ret;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode node = stack.pop();
            ret.add(node.val);
            cur = node.right;
        }
        return ret;
    }
}

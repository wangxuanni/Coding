package leetcode.tree.order.level;

import leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的右视图
 * https://leetcode-cn.com/problems/binary-tree-right-side-view/
 * @author keyu
 * @since 2022-04-26 18:01
 **/

public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        //层序遍历，获取最后一个节点
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return result;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int cur = queue.size();
            while (cur > 0) {
                TreeNode node = queue.poll();
                if (cur == 1) {
                    result.add(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                cur--;
            }
        }
        return result;
    }
}
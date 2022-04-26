package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的锯齿形层序遍历
 * https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
 *
 * @author keyu
 * @since 2022-04-26 11:15
 **/

public class ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();
        if (root == null) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int size = 0;
        int count = 0;

        boolean odd = true;
        while (!queue.isEmpty()) {
            size = queue.size();
            count = 0;
            LinkedList<Integer> temp = new LinkedList<>();

            while (count < size) {
                TreeNode node = queue.poll();
                if (odd) {
                    temp.addLast(node.val);
                } else {
                    temp.addFirst(node.val);

                }
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                count++;

            }
            list.add(temp);
            odd = !odd;
        }
        return list;

    }
}
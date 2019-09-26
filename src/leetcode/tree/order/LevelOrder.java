package leetcode.tree.order;

import interviews.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @description:
 * @author: wangxuanni
 * @create: 2019-09-24 09:52
 **/

public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return result;

        queue.offer(root);
        while (!queue.isEmpty()) {
            int cur = queue.size();
            List<Integer> list = new ArrayList<>();
            while (cur > 0) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);

                }
                cur--;

            }
            result.add(list);
        }
        return result;
    }
}

package offer.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上到下打印二叉树
 * https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/9ackoe/
 *
 * @author keyu
 * @since 2022-02-05 22:45
 **/

public class LevelOrder {
    public int[] levelOrder(TreeNode root) {
        if(root == null) return new int[0];
        Queue<TreeNode> queue = new LinkedList<TreeNode>(){{ add(root); }};
        ArrayList<Integer> ans = new ArrayList<>();
        while (queue.size()>0){
            TreeNode node = queue.poll();
            ans.add(node.val);
            if (node.left!=null)queue.offer(node.left);
            if (node.right!=null)queue.offer(node.right);
        }
        int[] ints = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
             ints[i]=ans.get(i);
        }
        return ints;

    }
}


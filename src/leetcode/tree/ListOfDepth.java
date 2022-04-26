package leetcode.tree;

import offer.LinkList.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 特定深度节点链表
 *
 * @author keyu
 * @since 2022-04-26 10:51
 **/

public class ListOfDepth {
    public ListNode[] listOfDepth(TreeNode tree) {
        if (tree == null) return null;
        //层次遍历，用每一层构造一个链表
        ArrayList<ListNode> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(tree);
        int size = 0;
        int count = 0;


        while (!queue.isEmpty()) {
            size = queue.size();
            count = 0;
            ListNode head = null;
            ListNode cur = null;
            while (count < size) {
                TreeNode node = queue.poll();
                ListNode next = new ListNode(node.val);
                if (head == null) {
                    head = next;
                    cur = next;
                } else {
                    cur.next = next;
                    cur = cur.next;

                }
                count++;

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);


            }
            list.add(head);
        }
        return list.toArray(new ListNode[0]);
    }
}

package leetcode.tree;

import offer.LinkList.ListNode;

/**
 * 有序链表转换二叉搜索树
 * https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/
 * @author keyu
 * @since 2022-04-26 17:00
 **/

public class SortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;

        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = head;
        //find the array's median
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }

        pre.next = null;

        TreeNode root = new TreeNode(slow.val);
        if (head != slow) {
            root.left = sortedListToBST(head);
        }
        root.right = sortedListToBST(slow.next);

        return root;
    }
}
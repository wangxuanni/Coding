package leetcode.sort;

import offer.LinkList.ListNode;

/**
 * 排序链表
 * https://leetcode-cn.com/problems/sort-list/
 * @author keyu
 * @since 2022-03-31 16:26
 **/

public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        //快慢指针找到链表的中点
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //快慢指针分别把链表分成两份，前段链表需处理尾部
        ListNode left = sortList(slow.next);
        slow.next = null;
        ListNode right = sortList(head);

        //创建一个伪头，分别遍历两个链表，哪个节点小就接到新链表上，其中一个链表遍历完了，把新链表的下一个指向另一个。
        ListNode fake = new ListNode(0);
        ListNode cur = fake;
        while (left != null && right != null) {
            if (left.val < right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        cur.next = left == null ? right : left;
        return fake.next;

    }
}

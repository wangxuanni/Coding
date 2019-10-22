package leetcode.link;

/**
 * @description:
 * @author: wangxuanni
 * @create: 2019-10-22 11:21
 **/

public class RemoveElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode n = head;
        ListNode pre = newHead;

        while (n != null) {
            if (n.val == val) {
                pre.next = n.next;
            } else {
                pre = pre.next;
            }
            n = n.next;

        }
        return newHead.next;
    }
}

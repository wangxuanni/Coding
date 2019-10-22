package leetcode.link;

/**
 * @description:
 * @author: wangxuanni
 * @create: 2019-10-22 11:37
 **/

public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode n1 = head;
        ListNode pre = newHead;
        ListNode n2, next;
        while (n1 != null) {
            n2 = n1.next;
            next = n2.next;
            if (n2 != null) {
                n1.next = next;
                n2.next = n1;
                pre.next = n2;
            }

            n1 = n1.next;
            pre = pre.next.next==null?null:pre.next.next;
        }
        return newHead.next;

    }

}

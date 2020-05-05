package leetcode.link;

/**
 * @description:
 * @author: wangxuanni
 * @create: 2020-04-26 17:17
 **/

public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        do {
            if (fast.next == null || fast.next.next == null) return null;
            slow = slow.next;
            fast = fast.next.next;
        } while (slow != fast);

        ListNode y = head;
        while (slow != y) {
            slow = slow.next;
            y = y.next;
        }
        return slow;
    }
}

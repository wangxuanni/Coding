package leetcode.link;

/**
 * 奇偶链表
 * https://leetcode-cn.com/problems/odd-even-linked-list/
 *
 * @author keyu
 * @since 2022-04-14 17:31
 **/

public class OddEvenList {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        oddEvenList(l1);
    }

    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode odd = new ListNode(0);
        ListNode even = new ListNode(0);
        ListNode oddCur = head;
        ListNode evenCur = head.next;
        odd.next = oddCur;
        even.next = evenCur;

        while (evenCur != null && evenCur.next != null) {
            oddCur.next = oddCur.next.next;
            oddCur = oddCur.next;
            evenCur.next = evenCur.next.next;
            evenCur = evenCur.next;

        }
        oddCur.next = even.next;
        return odd.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

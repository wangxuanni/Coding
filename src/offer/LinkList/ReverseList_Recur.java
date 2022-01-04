package offer.LinkList;

/**
 * @author keyu
 * @since 2021-12-31 14:49
 **/

public class ReverseList_Recur {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        return f(head.next, head);

    }

    public ListNode f(ListNode index, ListNode pre) {
        if (index == null) {
            return pre;
        }
        ListNode res = f(index.next, index);
        index.next = pre;
        return index;

    }
}

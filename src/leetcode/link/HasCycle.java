package leetcode.link;

/**
 * @description:
 * @author: wangxuanni
 * @create: 2020-04-25 12:14
 **/

public class HasCycle {
    public boolean hasCycle(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if (slow==fast)return true;
        }
        return false;

    }
}

package leetcode.link;

/**
 * @description:
 * @author: wangxuanni
 * @create: 2020-04-27 12:29
 **/

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return f(l1, l2, 0);
    }

    ListNode f(ListNode l1, ListNode l2, int add) {
        if (l1 == null && l2 == null && add == 0) {
            return null;
        }
        if (l1 != null) {
            add += l1.val;
        }
        if (l2 != null) {
            add += l2.val;
        }
        ListNode listNode = new ListNode(add%10);
        listNode.next=f(l1==null?null:l1.next,l2==null?null:l2.next,add>=10?1:0);
        return listNode;
    }


}

package leetcode.linkedlist;

import offer.LinkList.ListNode;

/**
 * @description:注意，为该值的元素可能有多个 Input:  1->2->6->3->4->5->6, val = 6
 * Output: 1->2->3->4->5
 * @author: wangxuanni
 * @create: 2019-09-27 10:12
 **/

public class RemoveElements {
    public ListNode removeElements(ListNode head, int val) {
        if(head==null){
            return null;
        }
        ListNode dumpN = new ListNode(-1);
        dumpN.next = head;
        ListNode pre = dumpN;
        while (pre.next != null) {//！
            if (pre.next.val == val) {
                pre.next = pre.next.next==null?null:pre.next.next;
                //pre = pre.next;会漏掉删除节点的下一个也是该值的情况

            } else {
                pre = pre.next;
            }
        }
        return dumpN.next;
    }
}

package leetcode.link;

/**
 * 旋转链表
 * @author keyu
 * @since 2022-05-16 21:19
 **/

public class RotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        if (head==null||k==0)return head;
        ListNode cur = head;
        int length = 0;
        ListNode pre = null;
        //step1 遍历得到链表的长度，并把链表连起来
        while (cur != null) {
            pre = cur;
            cur = cur.next;
            length++;
        }
        pre.next = head;
        // step2 因为如果链表长5，旋转6步和旋转1步是一样的，所以k=k%len
        //step3 旋转k步等于往前走k步，因为链表没法往前走，只能往后，所以我们变化一下。对于环形链表，往后走i步，等于往前走n-i，
        k = length - (k % length);


        //step4 找到新的头节点，断开上个节点对头节点的指向，就得到了新链表
        cur = head;
        pre=null;
        while (k > 0) {
            pre=cur;
            cur = cur.next;
            k--;
        }
        pre.next = null;
        return cur;
    }
}

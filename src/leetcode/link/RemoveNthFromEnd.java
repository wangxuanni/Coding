package leetcode.link;

/**
 * @description:while (n > 1) 要注意考虑[1,2]2这种特殊测试用例
 * @author: wangxuanni
 * @create: 2019-10-22 11:52
 **/

public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode end = head;
        ListNode node = newHead;
        while (n > 1) {
            if (end==null)return newHead.next;
            end = end.next;
            n--;
        }
        while (end.next!=null){
            end = end.next;
            node=node.next;
        }
        node.next=node.next.next;
        return newHead.next;
    }

}

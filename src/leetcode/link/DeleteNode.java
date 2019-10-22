package leetcode.link;

/**
 * @description:
 * @author: wangxuanni
 * @create: 2019-10-22 11:20
 **/

public class DeleteNode {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next=node.next.next;
    }
}

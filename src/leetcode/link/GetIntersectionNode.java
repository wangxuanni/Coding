package leetcode.link;

/**
 * @description:
 * @author: wangxuanni
 * @create: 2020-04-26 12:07
 **/

public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pointA = headA;
        ListNode pointB = headB;
        while (pointA != pointB) {
            pointA = pointA == null ? headB : pointA.next;
            pointB = pointB == null ? headA : pointB.next;
        }
        return pointA;


    }
}

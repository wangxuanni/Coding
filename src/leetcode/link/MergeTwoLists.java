package leetcode.link;

/**
 * @description:
 * @author: wangxuanni
 * @create: 2020-04-24 12:12
 **/

public class MergeTwoLists {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode listNode = mergeTwoLists(l1, l2);
        System.out.println(listNode);

    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode result = new ListNode(0);
        ListNode node = result;

        ListNode point1 = l1;
        ListNode point2 = l2;
        while (point1 != null && point2 != null) {
            if (point1.val < point2.val) {
                node.next = new ListNode(point1.val);
                node = node.next;
                point1 = point1.next;
            } else {
                node.next = new ListNode(point2.val);
                node = node.next;
                point2 = point2.next;
            }
        }
        if (point1 == null) {
            node.next = point2;
        } else {
            node.next = point1;
        }
        return result.next;


    }
}

package leetcode.link;

/**
 * 复杂链表的复制
 *
 * @author keyu
 * @since 2022-03-17 21:15
 **/

public class CopyRandomList {

    public Node copyRandomList(Node head) {
        if (head == null) return null;
        //复制链表
        Node cur = head;
        Node next;
        while (cur != null) {
            Node node = new Node(cur.val);
            next = cur.next;
            cur.next = node;
            node.next = next;
            cur = next;
        }
        cur = head;
        Node copy = head.next;
        //复制链表的random
        while (copy != null) {
            copy.random = cur.random == null ? null : cur.random.next;
            cur = copy.next;
            copy = cur == null ? null : cur.next;
        }
        cur = head;
        copy = head.next;
        Node result = head.next;
        while (copy.next != null) {
            cur.next = cur.next.next;
            copy.next = copy.next.next;
            cur = cur.next;
            copy = copy.next;

        }
        cur.next = null;
        return result;

    }

    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

}

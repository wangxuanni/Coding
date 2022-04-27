package leetcode.tree;

import java.util.LinkedList;

/**
 * 填充每个节点的下一个右侧节点指针
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/
 *
 * @author keyu
 * @since 2022-04-27 11:00
 **/

public class Connect {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    ;

    public Node connect(Node root) {
        if (root == null) return null;
        LinkedList<Node> queue = new LinkedList();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node pre = null;
            while (size > 0) {
                Node poll = queue.poll();
                if (pre == null) {
                    pre = poll;
                } else {
                    pre.next = poll;
                    pre = pre.next;
                }

                if (size == 1) {
                    poll.next = null;
                }
                size--;

                if (poll.left != null) queue.offer(poll.left);
                if (poll.right != null) queue.offer(poll.right);

            }
        }
        return root;
    }
}
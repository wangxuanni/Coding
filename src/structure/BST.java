package structure;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @description:
 * @author: wangxuanni
 * @create: 2019-10-30 20:54
 **/

public class BST<E extends Comparable<E>> {

    public static void main(String[] args) {
        int[] arr = {5, 3, 6, 8, 4, 2};
        BST bst = new BST();
        for (int i : arr) {
            bst.add(i);
        }
        bst.levelOrder();
        System.out.println();
        bst.removeMin();
        bst.levelOrder();
        bst.remove(3);
        System.out.println();
        bst.levelOrder();
    }

    public class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
        }
    }

    Node root;
    int size;

    public BST() {
    }

    public BST(E e) {
        this.root = new Node(e);
        size++;
    }

    public BST(Node n) {
        this.root = n;
        size++;
    }

    public void add(E e) {
        if (root == null) {
            root = new Node(e);
            return;
        }
        add(root, e);

    }

    public Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }
        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }
        return node;
    }

    public boolean contains(E e) {
        if (root == null) return false;
        return contains(root, e);

    }

    public boolean contains(Node node, E e) {
        if (node == null) return false;
        if (node.e.equals(e)) return true;
        if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            return contains(node.right, e);
        }
        return false;
    }

    /**
     * 返回一node为结点中最小的数
     *
     * @param node
     * @return
     */
    public Node getMin(Node node) {
        if (node.left == null) return node;

        return getMin(node.left);

    }

    public Node getMin() {
        if (root == null) return null;
        return getMin(root);
    }

    public void removeMin() {
        if (root == null) return;
        root = removeMin(root);
    }

    public Node removeMin(Node node) {
        if (node.left == null) {
            Node t = node.right;
            node.right = null;
            size--;
            node = t;
            return node;
        }
        node.left = removeMin(node.left);
        return node;
    }


    public void remove(E e) {
        if (root == null) return;
        root = remove(root, e);

    }

    public Node remove(Node node, E e) {
        if (node == null) return null;
        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        } else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        } else {
            if (node.right == null) {
                Node t = node.left;
                node.left = null;
                size--;
                return t;

            } else if (node.left == null) {
                Node t = node.right;
                node.right = null;
                size--;
                return t;

            } else {
                Node succuessor = getMin(node.right);
                succuessor.right = removeMin(node.right);
                succuessor.left = node.left;
                node.left = node.right = null;
                return succuessor;
            }

        }
    }

    public void preOrder() {
        preOrder(this.root);
    }

    public void preOrder(Node node) {
        if (node == null) return;
        System.out.print(node.e + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void preOrderBT() {
        if (this.root == null) return;
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node n = stack.pop();
            System.out.print(n.e + " ");
            if (n.right != null)
                stack.push(n.right);
            if (n.left != null)
                stack.push(n.left);
        }
    }

    public void levelOrder() {
        if (this.root == null) return;
        LinkedList<Node> link = new LinkedList<Node>();
        link.push(root);
        while (!link.isEmpty()) {
            Node n = link.pop();
            System.out.print(n.e + " ");
            if (n.left != null)
                link.offer(n.left);
            if (n.right != null)
                link.offer(n.right);
        }

    }

}

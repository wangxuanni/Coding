package leetcode.orther;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * 使用hashmap，自己实现双向链表
 *
 * @author keyu
 * @since 2022-04-11 14:49
 **/

public class LRUCache3 {
    HashMap<Integer, LinkedNode> map;
    LinkedNode head;
    LinkedNode tail;
    int capacity;

    static class LinkedNode {

        int key;
        int value;
        LinkedNode pre;
        LinkedNode next;

        public LinkedNode(int key, int value) {
            this.value = value;
            this.key = key;
        }
    }


    public LRUCache3(int capacity) {
        this.map = new HashMap<Integer, LinkedNode>();
        this.capacity = capacity;
        //空节点
        this.head = new LinkedNode(0, 0);
        this.tail = new LinkedNode(0, 0);
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        LinkedNode node = map.get(key);
        if (node == null) return -1;
        removeNode(node);
        addFirst(node);
        return node.value;
    }

    public void addFirst(LinkedNode node) {
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
        node.pre = head;
    }

    public LinkedNode removeLast() {
        LinkedNode delete = tail.pre;
        delete.pre.next = tail;
        tail.pre = delete.pre;
        return delete;
    }

    public void removeNode(LinkedNode node) {
        //不能是头和尾节点
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            removeNode(map.get(key));
            map.remove(key);
        }
        if (map.size() >= capacity) {
            LinkedNode last = removeLast();
            map.remove(last.key);
        }
        LinkedNode node = new LinkedNode(key, value);
        addFirst(node);
        map.put(key, node);
    }
}

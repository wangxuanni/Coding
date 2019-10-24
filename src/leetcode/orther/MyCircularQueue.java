package leetcode.orther;

import java.util.Arrays;

/**
 * @description:
 * @author: wangxuanni
 * @create: 2019-10-24 10:33
 **/

public class MyCircularQueue {
    public static void main(String[] args) {
        MyCircularQueue obj = new MyCircularQueue(3);
        obj.enQueue(1);
        obj.enQueue(2);
        obj.enQueue(3);

        System.out.println(obj.enQueue(4));
        System.out.println(obj.Rear());
        System.out.println(obj.isFull());

        obj.deQueue();
        System.out.println(obj.enQueue(4));
        System.out.println(obj.Rear());
    }

    private int data[];
    private int front, tail;
    private int size;
    private int len;

    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    public MyCircularQueue(int k) {
        data = new int[k + 1];
        len = k + 1;
        size = 0;
        front = 0;
        tail = 0;
    }

    public String toString() {
        return Arrays.toString(data);
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        if (size + 1 == len) return false;
        data[tail] = value;
        tail = (tail + 1) % len;
        size++;
        return true;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if (size == 0) return false;
        data[front] = -1;
        front = (front + 1) % len;
        size--;
        return true;
    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        if (size == 0) return -1;
        return data[front%len];

    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        if (size == 0) return -1;
        if (tail==0)return data[len-1];
        return data[(tail - 1)%len];
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        return size + 1 == len;
    }
}

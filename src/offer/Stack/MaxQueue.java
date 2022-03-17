package offer.Stack;

import java.util.LinkedList;

/**
 * 队列的最大值
 * @author keyu
 * @since 2022-03-12 21:44
 **/

public class MaxQueue {
    LinkedList<Integer> queue = new LinkedList<>();
    LinkedList<Integer> maxQueue = new LinkedList<>();

    public MaxQueue() {

    }

    public int max_value() {
        return maxQueue.getFirst();
    }

    public void push_back(int value) {
        queue.offer(value);
        if (!maxQueue.isEmpty()) {
            if (value <= maxQueue.getLast()) {
                maxQueue.offer(value);
            } else {
                while (!maxQueue.isEmpty() && value > maxQueue.getLast()) {
                    maxQueue.removeLast();
                }
                maxQueue.offer(value);
            }
        } else {
            maxQueue.offer(value);
        }
    }

    //["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
    //[[],[1],[2],[],[],[]]
    //输出: [null,null,null,2,1,2]
    public int pop_front() {
        Integer peek = queue.removeFirst();
        if (!maxQueue.isEmpty() && peek.equals(maxQueue.peek())) {
            maxQueue.removeFirst();
        }
        return peek;

    }
}
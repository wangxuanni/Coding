package leetcode.sort;

import java.util.PriorityQueue;

/**
 * @author keyu
 * @since 2022-03-31 10:26
 **/

public class MedianFinder {
    PriorityQueue<Integer> bigger = new PriorityQueue<>((x, y) -> y - x);
    PriorityQueue<Integer> smaller = new PriorityQueue<>();

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {

    }

    public void addNum(int num) {
        if (bigger.size() == smaller.size()) {
            smaller.offer(num);
            bigger.offer(smaller.poll());
        } else {
            bigger.offer(num);
            smaller.offer(smaller.poll());
        }

    }

    public double findMedian() {
        if (!bigger.isEmpty() && !smaller.isEmpty() && bigger.size() == smaller.size()) {
            return (bigger.peek() + smaller.peek()) / 2.0;
        } else if (!bigger.isEmpty()) {
            return (double) bigger.peek();
        }
        return 0.0;

    }

    /**
     * Your MedianFinder object will be instantiated and called as such:
     * MedianFinder obj = new MedianFinder();
     * obj.addNum(num);
     * double param_2 = obj.findMedian();
     */
    //leetcode submit region end(Prohibit modification and deletion)

}

package leetcode.sort;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/top-k-frequent-elements/submissions/
 * Top K Frequent Elements
 *
 * @author keyu
 * @since 2022-05-04 18:52
 **/

public class TopKFrequent {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 3};
        topKFrequent(arr, 2);
    }

    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> frequentMap = new HashMap<Integer, Integer>();
        for (int num : nums) {
            frequentMap.put(num, frequentMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> heap =
                new PriorityQueue<Integer>((n1, n2) -> frequentMap.get(n1) - frequentMap.get(n2));


        for (Integer value : frequentMap.keySet()) {
            heap.add(value);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        int[] arr = new int[k];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = heap.poll();
        }
        return arr;

    }
}
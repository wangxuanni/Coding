package leetcode.stack;

import java.util.HashMap;
import java.util.Stack;

/**
 * 下一个更大元素
 * https://leetcode-cn.com/problems/next-greater-element-i/
 * @author keyu
 * @since 2022-03-17 21:31
 **/

public class NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) return new int[0];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(nums2[nums2.length - 1]);
        for (int i = nums2.length - 2; i >= 0; i--) {
            while (!stack.isEmpty() && nums2[i] > stack.peek()) {
                stack.pop();
            }
            hashMap.put(nums2[i], stack.isEmpty() ? -1 : stack.peek());
            stack.push(nums2[i]);
        }
        int arr[] = new int[nums1.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = hashMap.get(nums1[i]) == null ? -1 : hashMap.get(nums1[i]);

        }
        return arr;


    }
}
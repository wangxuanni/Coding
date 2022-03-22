package leetcode.sort;

import java.util.Arrays;

/**
 * 最小K个数
 *
 * @author keyu
 * @since 2022-03-22 18:26
 **/

public class SmallestK {
    public int[] smallestK(int[] arr, int k) {
        if (k >= arr.length) return arr;
        if (k == 0) return new int[0];
        return partion(arr, k, 0, arr.length - 1);
    }

    public int[] partion(int[] arr, int k, int start, int end) {
        int s = start, e = end;

        while (s < e) {
            while (s < e && arr[s] <= arr[end]) s++;
            while (s < e && arr[e] >= arr[end]) e--;
            swap(arr, s, e);
        }
        swap(arr, s, end);
        if (k < s) partion(arr, k, start, s - 1);
        if (k > s) partion(arr, k, s + 1, end);
        return Arrays.copyOf(arr, k);

    }

    public static void swap(int[] nums, int i, int j) {
        // 交换 nums[i] 和 nums[j]
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
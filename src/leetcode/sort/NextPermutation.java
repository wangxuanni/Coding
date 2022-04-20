package leetcode.sort;

import java.util.Arrays;

/**
 * 下一个排列
 * @author keyu
 * @since 2022-04-19 16:14
 **/

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2) return;

        int i = nums.length - 2;
        //注意边界nums[i] >= nums[i + 1]
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        //此时nums[i]<nums[i+1]
        int j = nums.length - 1;
        if (i >= 0) {
            //注意边界nums[i] >= nums[j]
            while (j > i && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reserve(nums, i + 1, nums.length - 1);

    }

    public void reserve(int arr[], int i, int j) {
        while (i < j) {
            if (arr[i] > arr[j])
                swap(arr, i, j);
            i++;
            j--;
        }
    }

    public void swap(int arr[], int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;

    }
}

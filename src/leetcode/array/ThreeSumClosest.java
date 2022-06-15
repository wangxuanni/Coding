package leetcode.array;

import java.util.Arrays;

/**
 * 最接近三数之和
 * @author keyu
 * @since 2022-05-13 15:30
 **/

public class ThreeSumClosest {
    public static void main(String[] args) {
        int[] ints = {1, 2, 4, 8, 16, 32, 64, 128};
        threeSumClosest(ints,82);
    }
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int start = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                sum = nums[i] + nums[start] + nums[end];
                int closeValue = Math.abs(target - sum);
                if (closeValue == 0) return sum;
                if (closeValue < min) {
                    result = sum;
                    min = closeValue;
                }
                if (target > sum) {
                    start++;
                } else {
                    end--;
                }
            }

        }
        return result;
    }
}

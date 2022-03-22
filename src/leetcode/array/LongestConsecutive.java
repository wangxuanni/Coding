package leetcode.array;

import java.util.HashMap;

/**
 * 最长连续序列
 * https://leetcode-cn.com/problems/longest-consecutive-sequence/
 * @author keyu
 * @since 2022-03-22 10:43
 **/

public class LongestConsecutive {
    public static void main(String[] args) {
        int[] ints = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(ints));

    }

    public static int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int element = nums[i] + 1;
            int count = 1;
            while (map.containsKey(element++)) {
                count++;
                max = Math.max(max, count);
            }
        }
        return max;

    }
}

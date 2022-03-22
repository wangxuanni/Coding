package leetcode.array;

import java.util.HashMap;
import java.util.HashSet;

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
        if (nums == null || nums.length == 0) return 0;
        HashSet<Integer> map = new HashSet<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            map.add(nums[i]);
        }

        int max = 1;
        for (int i : map) {
            if (map.contains(i - 1)) continue;
            int element = i + 1;
            int count = 1;
            while (map.contains(element)) {
                count++;
                element++;
            }
            max = Math.max(max, count);
        }
        return max;

    }
}
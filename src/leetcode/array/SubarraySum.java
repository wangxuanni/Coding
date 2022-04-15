package leetcode.array;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 子数组之和
 * @author keyu
 * @since 2022-03-25 14:56
 **/

public class SubarraySum {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(i, nums[i]);
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int target = k - nums[i];
            Integer integer = map.get(target);
            if (integer != null && !integer.equals(i)) {
                count++;
            }
        }

        return count;
    }
}

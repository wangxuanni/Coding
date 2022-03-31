package leetcode.pre;

import java.util.HashMap;

/**
 * 三数之和
 * @author keyu
 * @since 2022-03-28 10:05
 **/

public class SubarraySum {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int result = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            count = map.get(sum - k);
            if (count > 0) {
                result += count;
            }
            Integer orDefault = map.getOrDefault(sum, 0);
            map.put(sum, ++orDefault);
        }
        return result;
    }
}
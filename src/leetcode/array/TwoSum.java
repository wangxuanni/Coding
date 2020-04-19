package leetcode.array;

import java.util.HashMap;

/**
 * @description: Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1]
 * @author: wangxuanni
 * @create: 2019-09-22 16:01
 **/
public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        System.out.println(twoSum2(arr, 9));
    }

    /**
     * 解法一：暴力O（n^2）
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int s = 0;
        int e = nums.length - 1;
        while (s < e) {
            int sum = nums[s] + nums[e];
            if (sum == target) {
                result[0] = s;
                result[1] = e;
                break;
            } else if (sum > target) {
                e--;
            } else {
                s++;
            }
        }
        return result;
    }

    /**
     * 解法二：将元素去全放入查找表中，之后遍历每一个元素i，查找target-i。
     * 因为要返回的是索引，所以不能简单的使用set，得使用map，key是这个i，map是索引
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int[] ints = new int[2];
        for (int i = 0; i < nums.length; i++) {
            hm.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int j = target - nums[i];
            if (hm.containsKey(j) && hm.get(j) != i) {
                ints[0] = i;
                ints[1] = hm.get(j);
            }
        }
        return ints;
    }
}

package leetcode.array.pionter;

/**
 * @description:输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 * @author: wangxuanni
 * @create: 2019-10-15 22:09
 **/

public class MinSubArrayLen {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.println(minSubArrayLen(15, arr));
    }

    public static int minSubArrayLen(int s, int[] nums) {
        if(nums.length==0)
            return 0;
        int r = -1;
        int l = 0;
        int sum = 0;
        int min = nums.length+1;
        while (l < nums.length) {

            if (r+1 < nums.length && sum < s) {
                sum += nums[++r];
                if (sum >= s) {
                    min = Math.min(min, r - l + 1);
                }
            } else {
                sum -= nums[l++];
            }

        }
        return min == nums.length+1 ? 0 : min;
    }
}

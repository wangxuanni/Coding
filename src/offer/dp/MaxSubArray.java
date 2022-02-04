package offer.dp;

/**
 * 连续子数组的最大和
 * https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/59gq9c/
 * @author keyu
 * @since 2022-02-04 18:14
 **/

public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
//            if (nums[i-1] > 0) {
//                nums[i] += nums[i-1];
//            }
            nums[i]+=Math.max(nums[i-1],0);
            max = Math.max(nums[i],max);
        }
        return max;
    }
}
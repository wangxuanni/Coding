package leetcode.dp;

/**
 * 打家劫舍2
 * @author keyu
 * @since 2022-04-13 18:27
 **/

public class Rob2 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];

        return Math.max(dp(nums, 0, nums.length - 2, dp), dp(nums, 1, nums.length - 1, dp));
    }

    public static int dp(int[] nums, int s, int e, int[] dp) {
        if (e - s + 1 == 1) {
            return Math.max(nums[s], nums[e]);
        }
        dp[s] = nums[s];
        dp[s + 1] = Math.max(nums[s], nums[s + 1]);
        for (int i = s+2; i <= e; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[e];
    }

}
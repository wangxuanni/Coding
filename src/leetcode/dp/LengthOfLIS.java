package leetcode.dp;

/**
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 * @author keyu
 * @since 2022-04-10 12:33
 **/

public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] memo = new int[nums.length];
        int result = 0;

        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    memo[i] = Math.max(memo[j] + 1, memo[i]);
                }
            }
            result = Math.max(result, memo[i]);
        }
        return result + 1;
    }
}
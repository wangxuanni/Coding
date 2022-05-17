package leetcode.greedy;

/**
 * 跳跃游戏II
 *
 * @author keyu
 * @since 2022-05-17 12:08
 **/

public class CanJump2 {
    public int jump(int[] nums) {

        int left = 0;
        int right = nums[0];
        int jumpCount = nums.length == 1 ? 0 : 1;


        while (right < nums.length - 1) {
            int i = left;
            int longest = 0;
            while (i <= right) {
                longest = Math.max(longest, i + nums[i]);
                i++;
            }
            left = right + 1;


            right = longest;
            jumpCount++;
        }
        return jumpCount;


    }
}

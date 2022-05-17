package leetcode.greedy;

/**
 * 跳跃游戏
 * @author keyu
 * @since 2022-05-16 19:52
 **/

public class CanJump {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int max = 0;
        //输入：nums = [2,3,1,1,4]
        //输出：true
        //解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。

        //输入：nums = [3,2,1,0,4]
        //输出：false
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, i + nums[i]);
            if (max >= nums.length - 1) {
                return true;
            }
            if (max <= i) {
                return false;
            }

        }
        return false;
    }

}

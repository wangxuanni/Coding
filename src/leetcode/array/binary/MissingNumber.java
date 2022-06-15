package leetcode.array.binary;

/**
 * 0～n-1中缺失的数字
 * https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof/
 *
 * @author keyu
 * @since 2022-05-28 17:43
 **/

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int left = -1, right = nums.length;
        while (left + 1 < right) {
            // Prevent (left + right) overflow
            int mid = left + (right - left) / 2;
            if (nums[mid] == mid) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return right;
    }
}

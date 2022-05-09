package leetcode.array;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * 删除有序数组中的重复项
 *
 * @author keyu
 * @since 2022-04-27 17:21
 **/

public class RemoveDuplicates {
    public static void main(String[] args) {
        removeDuplicates(new int[]{1, 1, 1, 2, 3, 35});
    }

    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int fast = 1;
        int slow = 1;
        while (fast < nums.length) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow++] = nums[fast];
            }
            fast++;

        }
        return slow;
    }
}
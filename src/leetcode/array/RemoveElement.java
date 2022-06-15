package leetcode.array;

/**
 * 移除元素
 * 和删除数组的重复项很像
 * @author keyu
 * @since 2022-05-12 15:52
 **/

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                swap(nums, result++, i);
            }
        }
        return result;

    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

package leetcode.pionter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 * @author keyu
 * @since 2022-03-29 10:53
 **/

public class ThreeSum {
    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        threeSum(arr);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) return result;
        int len = nums.length - 1;
        int mid;
        int right;
        int sum;
        Arrays.sort(nums);

        for (int left = 0; left <= len; left++) {
            if (nums[left] > 0) continue;
            if (left > 0 && nums[left] == nums[left - 1]) continue;
            mid = left + 1;
            right = len;
            while (mid < right) {
                sum = nums[left] + nums[mid] + nums[right];
                if (sum == 0) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[left]);
                    list.add(nums[mid]);
                    list.add(nums[right]);
                    result.add(list);
                    while (mid < right && nums[right] == nums[right - 1]) right--;
                    while (mid < right && nums[mid] == nums[mid + 1]) mid++;
                    mid++;
                    right--;
                    //如果是mid和right各往中间靠一步的情况，不用去重。因为三元组除自身外，还有另一个元素也比那里
                } else if (sum > 0) {
                    //right也是，跳过重复。
                    right--;
                } else {
                    //如果mid的下一个与mid相等，则mid往后移一位
                    mid++;
                }
            }
        }
        return result;
    }
}

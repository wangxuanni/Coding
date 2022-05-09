package leetcode.pionter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author keyu
 * @since 2022-05-05 16:36
 **/

public class FourSum {
    public static void main(String[] args) {
        System.out.println(fourSum(new int[] {2,2,2,2,2}, 8));
    }
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i >= 1 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int start = j + 1;
                int end = nums.length - 1;
                while (start < end) {
                    int sum = nums[start] + nums[end] + nums[i] + nums[j];
                    if (sum == target) {
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[start]);
                        list.add(nums[end]);
                        result.add(list);
                        while (start < end && nums[start] == nums[start + 1]) {
                            start++;
                        }
                        start++;
                        while (start < end && nums[end] == nums[end - 1]) {
                            end--;
                        }
                        end--;
                    } else if (sum < target) {
                        start++;
                    } else {
                        end--;
                    }
                }

            }

        }
        return result;

    }
}
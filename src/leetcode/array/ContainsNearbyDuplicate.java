package leetcode.array;

import java.util.HashSet;

/**
 * @description:
 * @author: wangxuanni
 * @create: 2019-10-21 19:32
 **/

public class ContainsNearbyDuplicate {
    public static void main(String[] args) {
        int[]arr={1,2,3,1,2,3};
        System.out.println(containsNearbyDuplicate(arr,2));
    }
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);

        }
        return false;
    }
}
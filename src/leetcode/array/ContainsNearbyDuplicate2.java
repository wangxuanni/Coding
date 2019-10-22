package leetcode.array;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @description:
 * @author: wangxuanni
 * @create: 2019-10-21 19:32
 **/

public class ContainsNearbyDuplicate2 {
    public static void main(String[] args) {
        int[]arr={1,2,3,1,2,3};
        System.out.println(containsNearbyDuplicate2(arr,2));
    }
    public static boolean containsNearbyDuplicate2(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
            if (set.size() == k +1) {
                set.remove(nums[i-k]);
            }

        }
        return false;
    }
}
/*

 */
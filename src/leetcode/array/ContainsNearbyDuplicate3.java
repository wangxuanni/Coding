package leetcode.array;

import java.util.TreeSet;

/**
 * @description:
 * @author: wangxuanni
 * @create: 2019-10-21 19:32
 **/

public class ContainsNearbyDuplicate3 {
    public static void main(String[] args) {
        int[] arr = {-1, 2147483647};

        System.out.println(containsNearbyDuplicate3(arr, 1, 2147483647));
    }

    public static boolean containsNearbyDuplicate3(int[] nums, int k, int t) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            // if (set.contains(nums[i])) return true;
            int num = nums[i];

            //巨人中挑个矮的
            Integer ceiling = set.ceiling(num);
            //ceiling-t<=num 写成ceiling<=t+num是为了防止整型溢出
            if (ceiling != null && ceiling <= t + num) return true;
            //侏儒中挑个高的
            Integer floor = set.floor(num);
            //num-floor<=t
            if (floor != null && num <= t + floor) return true;
            set.add(num);
            if (set.size() == k + 1) {
                set.remove(nums[i - k]);
            }

        }
        return false;
    }
}
package offer.Array;

import java.util.HashSet;

/**
 * 扑克牌的顺子
 * @author keyu
 * @since 2022-03-21 10:14
 **/

public class IsStraight {
    public boolean isStraight(int[] nums) {
        //连续=不重复&&max-min=个数
        HashSet<Integer> set = new HashSet<>();
        int min = Integer.MAX_VALUE, max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) continue;
            if (set.contains(nums[i])) {
                return false;
            }
            max = nums[i] > max ? nums[i] : max;
            min = nums[i] < min ? nums[i] : min;
            set.add(nums[i]);
        }
        return max - min >= 2 && max - min <= 4;
    }
}

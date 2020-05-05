package leetcode.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @description:
 * @author: wangxuanni
 * @create: 2020-04-26 12:27
 **/

public class FindDisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            hashSet.add(num);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {
            if (!hashSet.contains(i))
                list.add(i);
        }
        return list;

    }
}

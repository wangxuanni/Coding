package leetcode.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @description:输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [9,4]
 * @author: wangxuanni
 * @create: 2019-10-19 15:43
 **/

public class Intersection {
    public static void main(String[] args) {
        int[] a1 = {1, 2, 2, 1};
        int[] a2 = {2, 2};
        int[] a3 = intersection(a1, a2);
        System.out.println(Arrays.toString(a3));

    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> resultSet = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }
        for (int i : nums2) {
            if (set.contains(i)) {
                resultSet.add(i);
            }
        }
        int[] a1 = new int[resultSet.size()];

        int ind = 0;
        for (Integer integer : resultSet) {
            a1[ind++] = integer;
        }

        return a1;
    }
}

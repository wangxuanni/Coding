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
        int[] a1 = {4, 9, 5};
        int[] a2 = {9, 4, 9, 8, 4};
        int[] a3 = intersection(a1, a2);
        System.out.println(Arrays.toString(a3));

    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            set2.add(nums2[i]);
        }
        set.retainAll(set2);
        int[] a1 = new int[set.size()];
        int ind = 0;
        for (Integer integer : set) {
            a1[ind++] = integer;
        }

        return a1;
    }
}

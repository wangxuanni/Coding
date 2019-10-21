package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @description:如果数组2中的元素在map中存在（出现次数大于0），该元素就是一个交集元素，
 * 我们就将其存入返回数组中并且将map中该元素的出现次数减一即可.
 * 因为要计数，所以要多一个信息存储的位置。
 * @author: wangxuanni
 * @create: 2019-10-21 15:09
 **/

public class Intersection2 {
    public static void main(String[] args) {
        int[] a1 = {4,9,5};
        int[] a2 = {9,4,9,8,4};
        int[] a3 = intersection2(a1, a2);
        System.out.println(Arrays.toString(a3));

    }

    public static int[] intersection2(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            Integer t = hm.get(nums1[i])==null?0:hm.get(nums1[i]);
            hm.put(nums1[i], t + 1);
        }
        for (int i = 0; i < nums2.length; i++) {
            Integer t = hm.get(nums2[i])==null?0:hm.get(nums2[i]);

            if (t != 0) {
                list.add(nums2[i]);
                hm.put(nums2[i], t - 1);
            }
        }int []result=new int[list.size()];
        int ind=0;
        for (Integer integer : list) {
            result[ind++]=integer;
        }
        return result;
    }
}

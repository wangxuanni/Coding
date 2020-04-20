package leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: wangxuanni
 * @create: 2020-04-19 18:47
 **/

public class Subsets {
    public static void main(String[] args) {
        int[] num = {1, 2, 3};

        System.out.println(subsets(num));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        boolean[] v = new boolean[nums.length];
            f(0,nums, lists, new ArrayList());

        return lists;
    }

    static void f(int j,int[] nums, List<List<Integer>> lists, List<Integer> list) {
        //横向循环，纵向递归
        lists.add(new ArrayList<>(list));
        for (int i = j; i < nums.length; i++) {
            list.add(nums[i]);
            f(i,nums, lists, list);
            list.remove(list.indexOf(nums[i]));
        }

    }
}

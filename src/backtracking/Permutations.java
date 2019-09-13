package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: wangxuanni
 * @create: 2019-09-12 15:47
 **/

public class Permutations {
    /*    [1,2,3] have the following permutations:
                [
                [1,2,3],
                [1,3,2],
                [2,1,3],
                [2,3,1],
                [3,1,2],
                [3,2,1]
                ]*/
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(permute(nums).toString());
    }

    public static List<List<Integer>> permute(int[] nums) {
        boolean[] hasV = new boolean[nums.length];
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        f(nums, result, list, hasV);
        return result;
    }

    public static void f(int[] nums, List<List<Integer>> result, List<Integer> list, boolean[] hasV) {
        if (nums.length == list.size()) {
            result.add(new ArrayList<>(list));
        }
        for (int i = 0; i < nums.length; i++) {
            if (hasV[i]) {
                continue;
            }
            list.add(nums[i]);
            hasV[i] = true;
            f(nums, result, list, hasV);
            list.remove(list.size()-1);
            hasV[i] = false;
        }

    }
}

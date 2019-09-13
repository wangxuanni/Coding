package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: wangxuanni
 * @create: 2019-09-12 16:03
 **/
/*Input: n = 4, k = 2
        Output:
        [
        [2,4],
        [3,4],
        [2,3],
        [1,2],
        [1,3],
        [1,4],
        ]*/
public class Combinations {
    public static void main(String[] args) {
        System.out.println(combine(4, 2).toString());
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        f(1, n, k, result, list);
        return result;
    }

    public static void f(int start, int n, int k, List<List<Integer>> result, List<Integer> list) {
        if (k == 0) {
            System.out.println(list.toString());
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= n-k+1; i++) {
            System.out.println();
            list.add(i);
            f(i+1, n, k - 1, result, list);
            list.remove(list.size() - 1);
        }

    }

}

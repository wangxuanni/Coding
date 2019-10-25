package leetcode.greedy;

import java.util.Arrays;

/**
 * @description:这是我leetcode做过最简单的一道题
 * @author: wangxuanni
 * @create: 2019-10-18 00:47
 **/

public class FindContentChildren {
    public static void main(String[] args) {
        int[] arr = {1, 2};
        int[] arr2 = {3, 1, 2};
        System.out.println(findContentChildren(arr, arr2));
    }

    static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gi = g.length - 1;
        int si = s.length - 1;
        int i = 0;
        while (gi >= 0 && si >= 0) {
            if (g[gi] <= s[si]) {
                i++;
                gi--;
                si--;
            }else{
                gi--;
            }
        }
        return i;
    }
}
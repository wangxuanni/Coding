package leetcode.dp;

import java.util.Arrays;

/**
 * @description:
 * @author: wangxuanni
 * @create: 2019-10-27 16:03
 **/

public class Rob {
    public static void main(String[] args) {
        int []arr={2,7,9,3,1};
        System.out.println(rob(arr));
    }
    public static int rob(int[] num) {
        int prevMax = 0;
        int currMax = 0;
        for (int x : num) {
            int t=currMax;
            currMax=prevMax+x>t?prevMax+x:t;
            prevMax=t;
        }
        return currMax;
    }
}
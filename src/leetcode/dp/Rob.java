package leetcode.dp;

import java.util.Arrays;

/**
 * @description:
 * @author: wangxuanni
 * @create: 2019-10-27 16:03
 **/

public class Rob {
    public static void main(String[] args) {
        //[[2,7,9,3,1]]
        int []arr={2,7,9,3,1};
        System.out.println(rob(arr));
    }
//
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


    public static int robBT(int[] nums) {
        int[] memo = new int[nums.length];
        int n=nums.length;
        Arrays.fill(memo, -1);
        memo[n-1]=nums[n-1];

//第一层循环，遍历从nums的每一个数开始
        for (int i = n-2; i >=0; i--) {
//第二层循环，j从i到数组往后,每隔两个遍历 [2,7,9,3,1]
            for (int j = i; j < n; j++) {
                memo[i] = Math.max(memo[i], nums[j] +(j+2<n?nums[j+2]:0));
            }
        }

        return memo[0];


    }

    public static int robTB(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);

        return f(nums, 0, memo);
    }

    public static int f(int[] nums, int index, int[] memo) {

        if (index >= nums.length) return 0;
        if (memo[index] != -1) return memo[index];
        int res = 0;

        for (int i = index; i < nums.length; i++) {
            res = Math.max(res, nums[i] + f(nums, i + 2, memo));
        }
        memo[index] = res;
        return res;
    }
}
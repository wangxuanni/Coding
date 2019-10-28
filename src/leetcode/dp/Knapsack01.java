package leetcode.dp;

/**
 * @description:
 * @author: wangxuanni
 * @create: 2019-10-28 09:30
 **/

public class Knapsack01 {
    public static void main(String[] args) {
        int[] weight = {1, 2, 3};
        int[] value = {6, 10, 12};
//从n-1开始
        System.out.println(knapsack01BT(weight, value, 5, value.length-1));
    }

    public static int knapsack01BT(int[] weight, int[] value, int c, int index) {
        if (c <= 0 || index < 0) return 0;
        int res = knapsack01BT(weight, value, c, index - 1);
        if (weight[index] <= c) {
            //选择放入本物品，加价值并减重量
            res = Math.max(res, value[index]+knapsack01BT(weight, value, c - weight[index], index - 1));
        }
        return res;
}

    public static void knapsack01TB(int[] w, int[] v, int c) {

    }
}

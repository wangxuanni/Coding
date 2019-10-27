package leetcode.dp;

/**
 * @description:
 * @author: wangxuanni
 * @create: 2019-10-27 14:58
 **/

public class IntegerBreak {
    //自底向上
    public int integerBreakBT(int n) {
        int[] memo = new int[n + 1];
        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                memo[i] = max3(memo[i], j * i - j, j * memo[i - j]);
            }
        }
        return memo[n];
    }

    //自顶向下
    public int f(int n, int[] memo) {
        if (n == 1) return 1;
        int res = -1;
        if (memo[n]!=0)return memo[n];
        for (int i = 2; i < n; i++) {
            res=max3(res,i*(n-i),i*f(n-i,memo));
        }
        memo[n]=res;
        return res;
    }

    public int integerBreakTB(int n) {
        int[] memo = new int[n + 1];
        f(n, memo);
        return memo[n];

    }

    public int max3(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));

    }
}

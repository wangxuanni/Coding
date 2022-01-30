package offer.dp;
/**
 * @author wangxuanni
 * @since 2022-01-29 15:08
 * https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/50fxu1/
 **/
public class Fibonacci {
    /**
     * 递归
     */
    public int fib(int n) {
        if (n == 1 || n == 0) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    /**
     * 非递归，性能更好
     * LeetCode的题目要求取余% 1000000007，否则当n等于45时结果开始错误
     */
    public int fib_for(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int r = 0;
        int n_1 = 1;
        int n_2 = 0;
        for (int i = 2; i <= n; ++i) {
            r = (n_1 + n_2) % 1000000007;
            n_2 = n_1;
            n_1 = r;
        }
        return r;
    }
}

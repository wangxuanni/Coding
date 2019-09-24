package leetcode.dp;

/**
 * @description:
 * @author: wangxuanni
 * @create: 2019-09-22 15:55
 **/

public class ClimbingStairs {
    public int f(int n) {
        if (n <= 2) {
            return n;
        }
        int pre1 = 1;
        int pre2 = 2;
        for (int i = 2; i < n; i++) {
           int cur = pre1 + pre2;
            pre1 = pre2;
            pre2=cur;

        }
        return pre2;
    }
}

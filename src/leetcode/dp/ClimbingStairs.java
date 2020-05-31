package leetcode.dp;

/**
 * @description:
 * @author: wangxuanni
 * @create: 2019-09-22 15:55
 **/

public class ClimbingStairs {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(climb(n));

        int[] memo = new int[n+1];
        //Arrays.fill(memo,0);
        System.out.println(climb_dp(n,memo));


    }

    static int climb(int n) {
        if (n==1)
            return 1;
        if (n==2)
            return 2;

        return climb(n-1)+climb(n-2);
    }
    static int climb_dp(int n,int []memo) {
        if (n==1)
            return 1;
        if (n==2)
            return 2;
        if (memo[n]==0)
            memo[n]= climb_dp(n-1,memo)+climb_dp(n-2,memo);
        return memo[n];
    }

    public int f(int n) {
        if (n <= 2) {
            return n;
        }
        int pre1 = 1;
        int pre2 = 2;
        for (int i = 2; i < n; i++) {
            int cur = pre1 + pre2;
            pre1 = pre2;
            pre2 = cur;
        }
        return pre2;
    }
}

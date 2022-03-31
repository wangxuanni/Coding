package offer.math;

/**
 * @author keyu
 * @since 2022-03-16 17:26
 **/

public class CuttingRope {
    public static void main(String[] args) {

        System.out.println(cuttingRope(2));
    }

    public static int cuttingRope(int n) {
        if (n == 1) return 1;
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            int max = 0;
            for (int j = 1; j < i; j++) {
                max = Math.max(i * n - i, i * cuttingRope(n - i));
            }
            dp[i] = max;
        }
        return dp[dp.length - 1];
    }
}

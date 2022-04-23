package leetcode.greedy;

import java.util.Arrays;

/**
 * 零钱兑换
 * https://leetcode-cn.com/problems/coin-change/
 *
 * @author keyu
 * @since 2022-04-22 10:22
 **/

public class CoinChange {

    public static void main(String[] args) {
        CoinChange c = new CoinChange();
        System.out.println(c.coinChange(new int[]{186, 419, 83, 408}, 6249));
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, 10000);
        dp[0] = 0;
        for (int j = 0; j < coins.length; j++) {

            for (int i = 1; i < dp.length; i++) {
                if (i < coins[j]) {
                    continue;
                }
                //原来需要多少枚，和用当前面值填充需要多少枚，谁最小。
                dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
            }
        }
        return dp[amount] == 10000 ? -1 : dp[amount];

    }
}

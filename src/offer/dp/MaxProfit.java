package offer.dp;

/**
 * 股票的最大利润
 * https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/58nn7r/
 * @author keyu
 * @since 2022-02-04 17:15
 **/

public class MaxProfit {
    //转移方程 dp[i]=max(dp[i−1],prices[i]−min(prices[0:i]))
    public int maxProfit(int[] prices) {
        if (prices==null||prices.length<=0)return 0;
        int min = prices[0];
        int result = 0;
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(prices[i], min);
            result =Math.max(result,prices[i]-min);
        }
        return result;
    }
}

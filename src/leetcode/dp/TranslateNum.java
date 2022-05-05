package leetcode.dp;

/**
 * @author keyu
 * @since 2022-05-05 18:22
 **/

public class TranslateNum {
    public int translateNum(int num) {
        String numStr = String.valueOf(num);
        int[] dp = new int[numStr.length()];
        dp[0] = 1;
        dp[1] = 1;
        String pre = "";
        Integer preInt = 0;
        for (int i = 1; i < numStr.length(); i++) {

            pre = numStr.substring(i - 2, i);
            preInt = Integer.valueOf(pre);
            if (10 <=preInt&& preInt <= 25) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }

        }
        return dp[numStr.length()];
    }
}

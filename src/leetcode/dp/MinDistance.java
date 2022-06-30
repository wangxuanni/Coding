package leetcode.dp;

/**
 * 编辑距离
 * @author keyu
 * @since 2022-05-15 19:37
 **/

public class MinDistance {
    public static void main(String[] args) {
        minDistance("ros","horse");
    }
    public static int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                char wordFirst = word1.charAt(i-1);
                char wordSecond = word2.charAt(j-1);
                if (wordFirst != wordFirst) {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                } else {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }

        }
        for (int[] ints : dp) {
            for (int anInt : ints) {
                System.out.print(anInt+",");
            }
            System.out.println();
        }
        return dp[word1.length()][word2.length()];

    }
}

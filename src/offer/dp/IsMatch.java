package offer.dp;

import com.sun.xml.internal.bind.v2.model.core.ID;

/**
 * 正则匹配
 *
 * @author wangxuanni
 * @since 2022-01-30 15:08
 * https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/9a1ypc/
 * <p>
 * 【两个字母】如果两个字母相同了，复制左上角的值
 * 如果两个字母不同，直接就是false。
 * 【*】往前挪两位的值，如果是true就是true，说明假设星号前面的字母没有，匹配不匹配取决于带星号字母的上一个字母。
 * 如果不是true，还有一种可能，如果前一个字母（就是带星号的这个字母）匹配了，可以复制上面一格的值。这里是代表*能匹配多个相同的值。比如A和A匹配，如果前面一直是A，匹配的是true，就可以延续下来。如果前面出现了一个B，那么false就会延续下来，即便当前值匹配也不行。
 * 【.】因为.和任意字母都是匹配的，所以直接复制左上角的值
 **/

public class IsMatch {
    public static void main(String[] args) {
        String s = "aab";
        String p = "c*a*b";
        System.out.println(isMatch(s, p));
        //System.out.println(right(s,p));
    }

    public static boolean right(String s, String p) {
        int m = s.length() + 1, n = p.length() + 1;
        boolean[][] dp = new boolean[m][n];
        dp[0][0] = true;
        // 初始化首行,如果p小于等于2，不需要初始化
        for (int j = 2; j < n; j += 2)
            dp[0][j] = dp[0][j - 2] && p.charAt(j - 1) == '*';
        // 状态转移
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (p.charAt(j - 1) == '*') {
                    if (dp[i][j - 2]) dp[i][j] = true;                                            // 1.
                    else if (dp[i - 1][j] && s.charAt(i - 1) == p.charAt(j - 2)) dp[i][j] = true; // 2.
                    else if (dp[i - 1][j] && p.charAt(j - 2) == '.') dp[i][j] = true;             // 3.
                } else {
                    if (dp[i - 1][j - 1] && s.charAt(i - 1) == p.charAt(j - 1)) dp[i][j] = true;  // 1.
                    else if (dp[i - 1][j - 1] && p.charAt(j - 1) == '.') dp[i][j] = true;         // 2.
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public static boolean isMatch(String s, String p) {
        int sLen1 = s.length() + 1;
        int pLen1 = p.length() + 1;

        boolean[][] arr = new boolean[sLen1][pLen1];
        arr[0][0] = true;
        //这里是从2开始，并且加2
        for (int j = 2; j < pLen1; j += 2)
            arr[0][j] = arr[0][j - 2] && p.charAt(j - 1) == '*';


        //都是从1开始,p对应j，s对应i
        for (int i = 1; i < sLen1; i++) {
            for (int j = 1; j < pLen1; j++) {
                char matchChar = p.charAt(j - 1);
                if ('*' == matchChar) {
                    //匹配规则*前的字符有字符串匹配或者没匹配上，都取决于匹配规则*前两个的字符，即dp[i][j-2]
                    if (arr[i][j - 2]) {
                        arr[i][j] = true;
                        //如果匹配规则*前两个的字符是没有匹配上的，
                    } else if (p.charAt(j - 2) == s.charAt(i - 1)||p.charAt(j - 2)  == '.') {
                        arr[i][j] = arr[i - 1][j];
                    }
                } else if (matchChar == '.' || matchChar == s.charAt(j-1)) {
                    arr[i][j] = arr[i - 1][j - 1];
                }


            }

        }
        return arr[sLen1-1][pLen1-1];
    }
}

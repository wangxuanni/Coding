package leetcode.dp;

import java.util.Arrays;

/**
 * @description:
 * @author: wangxuanni
 * @create: 2019-10-11 01:32
 **/

public class NumSquares {
    public static void main(String[] args) {
        numSquares(12);
    }
    public static int numSquares(int n) {
        // write your code here
        int[] dp = new int[n+1];  //对应的角标分解成最小完全平方数的最小个数
        Arrays.fill(dp, Integer.MAX_VALUE); //dp[]数组中所有的数据都置Integer.MAX_VALUE（int可以表示的最大数据）
        for(int i = 0; i * i <= n; i++)
            dp[i * i] = 1;  //小于等于n的所有的完全平方数的最小个数都是1
        System.out.println(Arrays.toString(dp));
        for(int i = 1; i <= n; i++) //看成是一个普通数（i）+完美平方数(j*j)
        {  //选定第一个数为 i
            for(int j = 1; i + j * j <= n; j++)
            {  //选定另一个数为 j*j
                System.out.println("dp["+(i + j * j)+"]="+"min("+dp[i] + 1+","+ dp[i + j * j]+")");
                dp[i + j * j] = Math.min(dp[i] + 1, dp[i + j * j]);  //从小到大查找
            }
        }
        System.out.println("dp[n]"+dp[n]);
        return dp[n];
    }

}

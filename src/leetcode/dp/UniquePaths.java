package leetcode.dp;

/**
 *
 * 不同路径
 * @author keyu
 * @since 2022-04-15 11:37
 **/

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[] matrix = new int[n];
        for (int i = 0; i < n; i++) {
            //初始化
            matrix[i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                matrix[j] = matrix[j] + matrix[j-1];
            }
        }
        return matrix[n - 1];
    }
}

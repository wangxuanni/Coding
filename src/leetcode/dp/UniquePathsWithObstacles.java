package leetcode.dp;

/**
 * 不同路径II
 * @author keyu
 * @since 2022-04-21 18:02
 **/

public class UniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        //初始化
        int[][] matrix = new int[m][n];
        boolean mBoo = false;
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                matrix[i][0] = 0;
                mBoo = true;
            }
            if (mBoo) {
                matrix[i][0] = 0;

            } else {
                matrix[i][0] = 1;
            }
        }
        boolean nBoo = false;
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                matrix[0][i] = 0;
                nBoo = true;
            }
            if (nBoo) {
                matrix[0][i] = 0;
            } else {
                matrix[0][i] = 1;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    matrix[i][j] = 0;
                } else {
                    matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1];
                }
            }
        }
        return matrix[m - 1][n - 1];
    }
}

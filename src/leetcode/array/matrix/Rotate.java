package leetcode.array.matrix;

/**
 * 旋转图像
 * @author keyu
 * @since 2022-04-01 11:46
 **/

public class Rotate {
    public static void main(String[] args) {
        int[][] matrix= {{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);
    }
    public static void rotate(int[][] matrix) {
        if (matrix == null) return;
        //旋转公式：列-》行，行-》列对称的列
        // （i，j）
        // （j,n-i-1）
        int temp = 0;
        int n = matrix.length;
        for (int i = 0; i < matrix.length / 2; i++) {
            for (int j = 0; j < (matrix[0].length + 1) / 2; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }

        }

    }
}

package offer.Array;

/**
 * 顺时针打印矩阵
 * @author keyu
 * @since 2022-03-11 12:18
 **/

public class SpiralOrder {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[0];

        int count = 0, left = 0, top = 0, right = matrix[0].length - 1, bottom = matrix.length - 1;
        int[] result = new int[(right + 1) * (bottom + 1)];
        while (true) {

            //left往右移动，top减一，直到top>=bottom
            for (int i = left; i <= right; i++) {
                result[count++] = matrix[top][i];
                //System.out.println(result[count - 1]);

            }
            if (++top > bottom) break;
            //top往下移动，right减一，直到right<=left
            for (int i = top; i <= bottom; i++) {
                result[count++] = matrix[i][right];
                //System.out.println(result[count - 1]);

            }
            if (--right < left) break;

            //right往左移动，bottom加一，直到bottom<=top
            for (int j = right; j >= left; j--) {
                result[count++] = matrix[bottom][j];
                //System.out.println(result[count - 1]);

            }
            if (--bottom < top) break;
            //bottom往上移动，left加一，直到left>=right
            for (int j = bottom; j >= top; j--) {
                result[count++] = matrix[j][left];
                //System.out.println(result[count - 1]);

            }
            if (++left > right) break;

        }
        return result;
    }
}
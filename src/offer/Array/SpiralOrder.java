package offer.Array;

/**
 * @author keyu
 * @since 2022-03-11 12:18
 **/

public class SpiralOrder {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[0];
        int xStart = 0, y = matrix[0].length - 1, yStart = 0, x = matrix.length - 1, count = 0;
        int[] res = new int[(y + 1) * (x + 1)];
        while (true) {
            for (int i = xStart; i <= y; i++) res[count++] = matrix[yStart][i]; // left to right
            if (++yStart > x) break;
            for (int i = yStart; i <= x; i++) res[count++] = matrix[i][y]; // top to bottom
            if (xStart > --y) break;
            for (int i = y; i >= xStart; i--) res[count++] = matrix[x][i]; // right to left
            if (yStart > --x) break;
            for (int i = x; i >= yStart; i--) res[count++] = matrix[i][xStart]; // bottom to top
            if (++xStart > y) break;
        }
        return res;
    }
}
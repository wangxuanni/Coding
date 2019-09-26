package offer.Array;

public class SetZeroes {
    public void setZeroes(int[][] matrix) {
        int hang = matrix.length;
        int lie = matrix[0].length;
        int[] hArr = new int[hang];
        int[] lArr = new int[lie];
        for (int i = 0; i < hang; i++) {
            for (int j = 0; j < lie; j++) {
                if (matrix[i][j] == 0) {
                    hArr[i] = 1;
                    lArr[j] = 1;
                }
            }
        }
        for (int i = 0; i < hang; i++) {
            for (int j = 0; j < lie; j++) {
                if (hArr[i] == 1 || lArr[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}

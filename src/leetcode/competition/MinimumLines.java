package leetcode.competition;

import java.util.Arrays;

/**
 * 5.22周赛第三题
 * @author keyu
 * @since 2022-05-22 11:08
 **/

public class MinimumLines {
    public static void main(String[] args) {

    }

    public int minimumLines(int[][] stockPrices) {
        if (stockPrices.length == 1) return 0;
        Arrays.sort(stockPrices, (o1, o2) -> o1[0] - o2[0]);
        int res = 1;

        for (int i = 2; i < stockPrices.length; i++) {
            int[] A = stockPrices[i];
            int[] B = stockPrices[i - 1];
            int[] C = stockPrices[i - 2];

            if ((A[1] - B[1]) * (B[0] - C[0]) != (B[1] - C[1]) * (A[0] - B[0])) {
                res++;
            }
        }
        return res;

    }
}
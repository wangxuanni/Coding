package leetcode.array;

import java.util.HashMap;

/**
 * @description:
 * @author: wangxuanni
 * @create: 2019-10-21 15:54
 **/

public class FourSumCount {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int result = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                Integer t = hm.get(A[i] + B[j]) == null ? 0 : hm.get(A[i] + B[j]);

                hm.put(A[i] + B[j], t + 1);
            }
        }
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int t = 0 - C[i] - D[j];
                if (hm.containsKey(t)) {
                    result+=hm.get(t);
                }
            }
        }
        return result;
    }

}

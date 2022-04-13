package leetcode.orther;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 合并区间
 * @author keyu
 * @since 2022-04-13 15:36
 **/

public class Merge {
    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        int[] oneArr = new int[len];
        int[] zeroArr = new int[len];

        for (int i = 0; i < intervals.length; i++) {
            oneArr[i] = intervals[i][1];
            zeroArr[i] = intervals[i][0];
        }
        Arrays.sort(oneArr);
        Arrays.sort(zeroArr);
        ArrayList<int[]> result = new ArrayList<int[]>();
        int start = 0, zero = 0, one = 0, count = 0;
        while (zero < len && one < len) {
            if (zeroArr[zero] <= oneArr[one]) {
                if (count == 0) {
                    start = zeroArr[zero];
                }
                count++;
                zero++;
            } else {
                count--;
                one++;
            }
            if (count == 0) {
                result.add(new int[]{start, oneArr[one-1]});
            }
        }
        if (one < len) {
            result.add(new int[]{start, oneArr[len - 1]});
        }
        int[][] res = new int[result.size()][2];
        for (int i = 0; i < res.length; i++) {
            res[i] = result.get(i);
        }
        return res;
    }
}

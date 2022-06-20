package leetcode.orther;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 合并区间
 * 错误思路：根据1排序，A2>=B1&&A2<=B2 ,的方法行不通，因为如果前一个区间的范围包括了后一个区间[2,6][3,4]
 * 正确思路：根据1排正序，如果1相等，根据2排倒序。只要区间小于等于A2的全部合并。
 * [2,6][3,4][5,8]
 * [2,6][3,4][5,8]
 *
 * @author keyu
 * @since 2022-04-13 15:36
 **/

public class Merge {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(final int[] o1, final int[] o2) {
                if (o1[0] == o2[0]) {
                    return o2[1] - o1[1];
                } else {
                    return o1[0] - o2[0];
                }
            }
        });
        ArrayList<int[]> res = new ArrayList<>();
        int[] temp = intervals[0];
        for (int[] arr : intervals) {
            if (arr[0] <= temp[1]) {
                if (temp[1] < arr[1]) {
                    temp[1] = arr[1];
                }
            } else {
                res.add(temp);
                temp = arr;

            }

        }
        res.add(temp);
        return res.toArray(new int[res.size()][]);
    }
}

package leetcode.simulation;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 会议室II
 * @author keyu
 * @since 2022-04-12 11:11
 **/

public class MinMeetingRooms2 {
    public int minMeetingRooms(int[][] intervals) {

        int len = intervals.length;
        int[][] data = new int[len * 2][2];
        int dateIndex = 0;
        for (int i = 0; i < intervals.length; i++) {
            data[dateIndex++] = new int[]{intervals[i][0], 1};
            data[dateIndex++] = new int[]{intervals[i][1], -1};
        }
        Arrays.sort(data, new Comparator<int[]>() {
            @Override
            public int compare(final int[] o1, final int[] o2) {
                return o1[0] - o2[0] == 0 ? o1[1] - o2[1] : o1[0] - o2[0];
            }
        });
        int count = 0;
        int max = 0;
        for (int i = 0; i < data.length; i++) {
            count += data[i][1];
            max = Math.max(max, count);

        }
        return max;
    }
}

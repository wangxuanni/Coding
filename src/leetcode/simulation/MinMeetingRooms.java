package leetcode.simulation;

import java.util.Arrays;

/**
 * @author keyu
 * @since 2022-04-12 10:39
 **/

public class MinMeetingRooms {
    public static void main(String[] args) {
        int[][] arr = {{0, 30}, {5, 10}, {15, 20}};
        minMeetingRooms(arr);
    }

    public static int minMeetingRooms(int[][] intervals) {
        int len = intervals.length;
        int[] indexZero = new int[len];
        int[] indexOne = new int[len];
        for (int i = 0; i < len; i++) {
            indexZero[i] = intervals[i][0];
            indexOne[i] = intervals[i][1];
        }
        Arrays.sort(indexOne);
        Arrays.sort(indexZero);
        int theRoomCount = 0;
        int max = 0;
        int zero = 0;
        int one = 0;

        while (zero < len && one < len) {
            if (indexZero[zero] < indexOne[one]) {
                theRoomCount++;
                zero++;
                max = Math.max(max, theRoomCount);
            } else {
                theRoomCount--;
                one++;
            }

        }
        if (zero < len) {
            theRoomCount += len - zero;
            max = Math.max(max, theRoomCount);
        }

        return max;
    }
}
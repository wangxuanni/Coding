package leetcode.simulation;

/**
 * 会议室
 *
 * @author keyu
 * @since 2022-04-12 10:19
 **/

public class CanAttendMeetings {
    public boolean canAttendMeetings(int[][] intervals) {
        //A.1<=B.0 || A.0>=B.1
        for (int i = 0; i < intervals.length; i++) {
            for (int j = i + 1; j < intervals.length; j++) {
                if (intervals[i][1] <= intervals[j][0] || intervals[i][0] >= intervals[j][1]) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}

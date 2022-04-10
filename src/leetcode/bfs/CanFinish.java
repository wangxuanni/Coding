package leetcode.bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 课程表
 * https://leetcode-cn.com/problems/course-schedule/
 * @author keyu
 * @since 2022-04-09 14:12
 **/

public class CanFinish {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0) return true;
        //题目条件里很重要的一点是 prerequisites[i] = [ai, bi] 它的范围是 0 <= ai, bi < numCourses
        // 所以嵌套列表和积分数组可以把坐标当做课程号，没有记录前置课的坐标默认是0，可以直接拿来学习。
        ArrayList<List<Integer>> lists = new ArrayList<>(numCourses);
        int[] beforeNum = new int[numCourses];
        LinkedList<Integer> queue = new LinkedList<>();
        int result = 0;
        for (int i = 0; i < numCourses; i++) {
            lists.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int[] pre = prerequisites[i];
            lists.get(pre[1]).add(pre[0]);
            beforeNum[pre[0]]++;
        }
        for (int i = 0; i < beforeNum.length; i++) {
            if (beforeNum[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            Integer poll = queue.pollFirst();
            List<Integer> afterCourse = lists.get(poll);
            for (Integer course : afterCourse) {
                beforeNum[course]--;
                if (beforeNum[course] == 0) {
                    queue.offer(course);
                }
            }
            result++;
        }
        return result >= numCourses;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

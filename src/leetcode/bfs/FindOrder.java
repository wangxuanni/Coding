package leetcode.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 课程表2
 *
 * @author keyu
 * @since 2022-04-10 11:51
 **/

public class FindOrder {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (prerequisites == null) return new int[0];
        //题目条件里很重要的一点是 prerequisites[i] = [ai, bi] 它的范围是 0 <= ai, bi < numCourses
        // 所以嵌套列表和积分数组可以把坐标当做课程号，没有记录前置课的坐标默认是0，可以直接拿来学习。
        ArrayList<List<Integer>> lists = new ArrayList<>(numCourses);
        int[] beforeNum = new int[numCourses];
        LinkedList<Integer> queue = new LinkedList<>();
        int[] result = new int[numCourses];
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
        int i = 0;
        while (!queue.isEmpty()) {
            Integer poll = queue.pollFirst();
            List<Integer> afterCourse = lists.get(poll);
            for (Integer course : afterCourse) {
                beforeNum[course]--;
                if (beforeNum[course] == 0) {
                    queue.offer(course);
                }
            }
            result[i++] = poll;
        }
        //注意：对于不可能完成所有课程的情况要有一个判断，和课程表I一样，计数修完的课程是否能达到要求
        if (i != numCourses) {
            return new int[0];
        }
        return result;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

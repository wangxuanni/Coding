package leetcode.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * 课程表
 * https://leetcode-cn.com/problems/course-schedule/
 * @author keyu
 * @since 2022-04-09 14:12
 **/

public class CanFinishDfs {
    public static void main(String[] args) {
       // System.out.println(canFinish(3,new int[][]{{2,1},{1,0}})) ;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int[] statusArr = new int[numCourses];
        HashMap<Integer, ArrayList<Integer>> courseAndAfterList = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            ArrayList<Integer> orDefault = courseAndAfterList.getOrDefault(prerequisite[1], new ArrayList<Integer>());
            orDefault.add(prerequisite[0]);
            courseAndAfterList.put(prerequisite[1], orDefault);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(courseAndAfterList, statusArr, i)) return false;
        }
        return true;

    }

    public boolean dfs(HashMap<Integer, ArrayList<Integer>> courseAndAfterList, int[] statusArr, int num) {
        if (statusArr[num] == -1) return false;
        ArrayList<Integer> list = courseAndAfterList.get(num);
        if (list != null) {
            statusArr[num] = -1;
            for (Integer afterCourse : list) {
                if (statusArr[afterCourse] == 1) continue;
                if (!dfs(courseAndAfterList, statusArr, afterCourse)) return false;
            }
        }
        statusArr[num] = 1;

        return true;

    }
}
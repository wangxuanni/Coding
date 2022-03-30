package leetcode.orther;

/**
 * 任务调度器
 * https://leetcode-cn.com/problems/task-scheduler/
 * @author keyu
 * @since 2022-03-30 10:39
 **/

public class LeastInterval {
    public int leastInterval(char[] tasks, int n) {

        //统计出最大的任务
        //公式解释：1.最大的任务-1 =》最后一个不需要n个任务数 2.n+1因为除了间隔数还有任务执行数 3. x x是1的基础上加上有多少和最大任务数一样多的任务
        //计算公式：(maxTaskNum-1)*（n+1）+x
        //如果剩余任务数超过了冷却时间，所需时间就是任务数
        int maxTaskNum = 0;
        int[] count = new int[26];
        for (char task : tasks) {
            maxTaskNum = Math.max(maxTaskNum, ++count[task - 'A']);
        }
        int x = 0;
        for (int i : count) {
            if (maxTaskNum == i) x++;
        }
        return Math.max((maxTaskNum - 1) * (n + 1) + x, tasks.length);
    }
}

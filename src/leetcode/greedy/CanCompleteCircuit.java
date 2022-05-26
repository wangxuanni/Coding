package leetcode.greedy;

/**
 * 加油站
 * https://leetcode.cn/problems/gas-station/
 * @author keyu
 * @since 2022-05-20 21:57
 **/

public class CanCompleteCircuit {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasSum = 0;
        int costSum = 0;
        int startIndex = 0;
        int total = 0;
        for (int i = 0; i < gas.length; i++) {
            gasSum += gas[i];
            costSum += cost[i];
            total += gas[i] - cost[i];
            if (total < 0) {
                total = 0;
                startIndex = i + 1;
            }
        }
        if (gasSum < costSum) return -1;
        return startIndex;
    }
}

package offer.Stack;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 每日温度
 *
 * @author keyu
 * @since 2022-03-16 15:04
 **/

public class DailyTemperatures {
    public static void main(String[] args) {
        dailyTemperatures(new int[]{89, 62, 70, 58, 47, 47, 46, 76, 100, 70});
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length <= 1) return new int[0];
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[temperatures.length];
        stack.add(0);
        for (int i = 1; i < result.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                Integer pop = stack.pop();
                result[pop] = i - pop;
            }
            stack.push(i);

        }
        return result;
    }
}


package leetcode.stack;

import java.util.Stack;

/**
 * @author keyu
 * @since 2022-03-23 14:42
 **/

public class Trap {
    public static void main(String[] args) {
        int[] arr = {4, 2, 0, 3, 2, 5};
        System.out.println(trap(arr));
    }

    public static int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        for (int i = 0; i < height.length; i++) {
            //注意等于的情况不入栈，因为下一个元素等于上一个元素，接不住水，没有意义。
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                Integer pop = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int high = Math.min(height[i], height[stack.peek()]) - height[pop];
                int weith = i - stack.peek() - 1;
                result += high * weith;

            }
            stack.push(i);
        }
        return result;
    }
}
package offer.Stack;

import java.util.Stack;

/**
 * 栈的压入、弹出序列
 *
 * @author keyu
 * @since 2022-03-18 12:14
 **/

public class ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int poppedCount = 0;
        for (int i : pushed) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && stack.peek().equals(popped[poppedCount])) {
                stack.pop();
                poppedCount++;
            }
        }
        return poppedCount==popped.length;
    }
}

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
        // 如果当前栈不为空&&栈顶元素等于要弹出的元素，弹出元素
        // 否则入队列。如果两个数组都遍历完了返回true，如果入栈数组遍历完了，栈顶元素还是不等于弹出元素，返回false
        Stack<Integer> stack = new Stack<>();
        int pushedCount = 0, poppedCount = 0;
        while (poppedCount < popped.length || pushedCount < pushed.length) {
            if (!stack.isEmpty() && stack.peek().equals(popped[poppedCount])) {
                stack.pop();
                poppedCount++;
            } else if (pushedCount > pushed.length - 1) {
                return false;
            } else {
                stack.push(pushed[pushedCount++]);
            }
        }
        return true;
    }
}

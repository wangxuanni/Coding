package leetcode.stack;

import java.util.Stack;

/**
 * 计算器2
 *
 * @author keyu
 * @since 2022-05-17 15:47
 **/

public class Calculate2 {
    public int calculate(String s) {
        Stack<Integer> numStack = new Stack<>();
        char[] chars = s.toCharArray();
        int num = 0;
        int index = 0;
        char preOprea = '+';
        while (index < chars.length) {
            char c = chars[index];
            if (Character.isDigit(c)) {
                if (num > 0) {
                    num = num * 10 + c - '0';
                } else {
                    num = c - '0';
                }
            }
            if ((!Character.isDigit(c) && c != ' ') || index == chars.length - 1) {
                switch (preOprea) {
                    case '+':
                        numStack.push(num);
                        break;
                    case '-':
                        num -= 2 * num;
                        numStack.push(num);
                        break;

                    case '*':
                        num = numStack.pop() * num;
                        numStack.push(num);
                        break;

                    case '/':
                        num = numStack.pop() / num;
                        numStack.push(num);
                        break;
                }
                preOprea = c;
                num = 0;
            }
            index++;
        }
        int result = 0;
        while (!numStack.isEmpty()) {
            result += numStack.pop();
        }
        return result;
    }
}

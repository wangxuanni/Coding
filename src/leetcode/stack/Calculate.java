package leetcode.stack;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

/**
 * 计算器
 * @author keyu
 * @since 2022-05-07 18:01
 **/

public class Calculate {
    public int calculate(String s) {
        Stack<Integer> outsideSign = new Stack<>();
        outsideSign.push(1);
        char[] charArr = s.toCharArray();
        int index = 0;
        int sign = 1;
        int res = 0;
        while (index < charArr.length) {
            char c = charArr[index];
            if (c == ' ') {
                index++;
            } else if (c == '+') {
                sign = outsideSign.peek();
                index++;
            } else if (c == '-') {
                sign = -1 * outsideSign.peek();
                index++;
            } else if (c == '(') {
                outsideSign.push(sign);
                index++;
            } else if (c == ')') {
                outsideSign.pop();
                index++;
            } else {
                long num = 0L;
                while (index < charArr.length && Character.isDigit(charArr[index])) {
                    num = num * 10 + charArr[index] - '0';
                    index++;
                }

                res += sign * num;
            }
        }
        return res;
    }
}

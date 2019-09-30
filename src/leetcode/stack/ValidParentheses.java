package leetcode.stack;

import java.util.Stack;

/**
 * @description:'('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。()[]{}
 * @author: wangxuanni
 * @create: 2019-09-27 09:48
 **/

public class ValidParentheses {
    public static void main(String[] args) {

        System.out.println(new ValidParentheses().isValid("]"));
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[')
                stack.push(c);
            else {
                //防止“[”这种情况
                if (stack.isEmpty()) {
                    return false;
                }
                Character pop = stack.pop();
                if (c == ')' && pop != '(') {
                    return false;
                }
                if (c == '}' && pop != '{') {
                    return false;
                }
                if (c == ']' && pop != '[') {
                    return false;
                }

            }

        }
        return stack.isEmpty();
    }
}

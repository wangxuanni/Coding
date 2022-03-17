package leetcode.pionter;

/**
 * 反转字符串
 * https://leetcode-cn.com/problems/reverse-string/
 *
 * @author keyu
 * @since 2022-03-17 20:13
 **/

public class ReverseString {
    public void reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;
        char temp;
        while (start < end) {
            temp = s[start];
            s[start++] = s[end];
            s[end--] = temp;
        }

    }
}
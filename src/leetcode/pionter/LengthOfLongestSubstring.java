package leetcode.pionter;

/**
 * @description:输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * @author: wangxuanni
 * @create: 2019-09-28 19:49
 **/

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("bbbbb"));
    }

    public static int lengthOfLongestSubstring(String s) {
        byte[] abc = new byte[256];
        int r = -1;
        int l = 0;
        int max = 0;
        while (l < s.length()) {
            if (r + 1 < s.length() && abc[s.charAt(r + 1)] == 0) {
                abc[s.charAt(++r)]++;
            } else {
                abc[s.charAt(l++)]--;
            }
            max = Math.max(max, r - l + 1);

        }
        return max;
    }
}

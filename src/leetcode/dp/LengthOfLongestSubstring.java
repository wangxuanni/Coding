package leetcode.dp;

import java.util.HashMap;

/**
 * 最长不含重复字符的子字符串
 * https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/
 * @author keyu
 * @since 2022-04-18 21:32
 **/

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        lengthOfLongestSubstring("tmmzuxt");
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        int max = 1;
        int temp = 0;
        int startIndex = -1;
        for (int i = 0; i < chars.length; i++) {
            Integer orDefault = map.getOrDefault(chars[i], -1);
            startIndex = Math.max(startIndex, orDefault);
            map.put(chars[i], i);
            max = Math.max(max, i - startIndex);
        }
        return max;

    }
}

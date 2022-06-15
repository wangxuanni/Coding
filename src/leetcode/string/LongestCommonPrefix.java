package leetcode.string;

/**
 * 最长公共前缀
 * tps://leetcode-cn.com/problems/longest-common-prefix/
 *
 * @author keyu
 * @since 2022-04-28 12:10
 **/

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strings = {"flower", "flow", "flight"};
        longestCommonPrefix(strings);
    }
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        char[] common = strs[0].toCharArray();
        int min = common.length;
        //输入：strs = []

        for (int i = 1; i < strs.length; i++) {
            for (int j = 0; j < common.length; j++) {
                if (j > strs[i].length() - 1 || common[j] != strs[i].charAt(j)) {
                    min = Math.min(min, j);
                    continue;
                }
            }

        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < min; i++) {
            sb.append(common[i]);
        }
        return sb.toString();

    }
}
package leetcode.string;

/**
 * 实现 strStr()
 * https://leetcode-cn.com/problems/implement-strstr/@author keyu
 *
 * @since 2022-04-28 15:21
 **/

public class StrStr {
    public int strStr(String haystack, String needle) {
        if (needle == null || haystack == null || needle.trim().equals("")) return 0;
        for (int i = 0; i < haystack.length(); i++) {
            for (int j = 0; j < needle.length(); j++) {
                //注意考虑needle比haystack大的情况
                if (j + i > haystack.length() - 1) {
                    return -1;
                }
                if (needle.charAt(j) != haystack.charAt(i + j)) {
                    break;
                }
                if (j == needle.length() - 1 && needle.charAt(j) == haystack.charAt(i + j)) {
                    return i;
                }
            }

        }
        return -1;
    }
}

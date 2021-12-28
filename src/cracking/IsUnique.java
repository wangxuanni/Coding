package cracking;

/**
 * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
 * 空间复杂度O（1）
 * 时间复杂度O（n）
 *
 * @author keyu
 * @since 2021-12-27 14:26
 **/

public class IsUnique {
    public boolean isUnique(String astr) {
        boolean[] hasOur = new boolean[26];
        for (char c : astr.toCharArray()) {
            int index = c - 'a';
            if (hasOur[index] == false) {
                hasOur[index] = true;
            } else {
                return false;
            }
        }
        return true;
    }
}

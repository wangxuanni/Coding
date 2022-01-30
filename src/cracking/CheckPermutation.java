package cracking;

/**
 * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 *
 * @author wangxuanni
 * @since 2021-12-29 17:35
 **/

public class CheckPermutation {
    public boolean CheckPermutation(String s1, String s2) {
        int[] hasOur = new int[26];
        for (char c : s1.toCharArray()) {
            int index = c - 'a';
            hasOur[index]++;
        }
        for (char c : s2.toCharArray()) {
            int index = c - 'a';
            if (hasOur[index] == 0) {
                return false;
            } else {
                hasOur[index]--;
            }

        }
        for (int i : hasOur) {
            if (i > 0) {
                return false;
            }
        }
        return true;
    }
}

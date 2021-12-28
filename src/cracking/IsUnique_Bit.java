package cracking;

/**
 * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
 * 位运算
 *
 * @author keyu
 * @since 2021-12-27 14:26
 **/

public class IsUnique_Bit {
    public boolean isUnique(String s) {
        long left = 0;
        long right = 0;
        for (char c : s.toCharArray()) {
            if (c >= 64) {
                long bitIndex = 1L << (c - 64);
                if ((left & bitIndex) != 0) {
                    return false;
                }
                left |= bitIndex;
            } else {
                long bitIndex = 1L << c;
                if ((right & bitIndex) != 0) {
                    return false;
                }
                right |= bitIndex;
            }
        }
        return true;

    }
}

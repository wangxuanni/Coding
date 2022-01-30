package cracking;

/**
 * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
 * 位运算
 * 用Integer代替布尔数组
 * 该坐标会设置为1，如果原本位置是0，则会被设置为1，设置为出现过
 * 如果原本位置是0，说明之前已经出现过了，则返回false
 *
 * @author wangxuanni
 * @since 2021-12-27 14:26
 **/

public class IsUnique_Bit {

    public boolean isUnique(String astr) {
        Integer hasOurInt = new Integer(0);
        boolean[] hasOur = new boolean[26];
        for (char c : astr.toCharArray()) {
            int index = c - 'a';
            int i = index << 1;
            if ((i & hasOurInt) == 0) {
                hasOurInt |= i;
            } else {
                return false;
            }
        }
        return true;
    }
}

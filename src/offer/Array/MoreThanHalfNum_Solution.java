package offer.Array;

/**
 * 数组中出现次数超过一半的数字
 * https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/
 *
 * @author wangxuanni
 * @since 2021-06-27 14:37
 */
public class MoreThanHalfNum_Solution {
    public static int MoreThanHalfNum_Solution(int[] array) {
        int count = 1;
        int same = array[0];
        for (int i = 1; i < array.length; i++) {
            if (same == array[i]) {
                count++;
            } else {
                count--;
                //注意边界
                if (count < 0) {
                    same = array[i];
                    count = 0;
                }

            }
        }
        return same;
    }
}

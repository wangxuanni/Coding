package offer.Array;

/**
 * https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
 * 二维数组中的查找
 *
 * @author keyu
 * @since 2022-02-21 14:16
 **/

public class FindNumberIn2DArray {
    //[
    //  [1,   4,  7, 11, 15],
    //  [2,   5,  8, 12, 19],
    //  [3,   6,  9, 16, 22],
    //  [10, 13, 14, 17, 24],
    //  [18, 21, 23, 26, 30]
    //]
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        //注意这三个条件的顺序,空数组的情况，matrix[0].length == 0先判断会报错
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int i = matrix[0].length - 1;
        int j = 0;
        while (i >= 0 && j < matrix.length) {
            //如果下面的数比target小，往下走，否则往右走
            // 如果超出边界，则没找到
            if (matrix[j][i] == target) {
                return true;
            } else if (matrix[j][i] > target) {
                i--;
            } else {
                j++;
            }
        }
        return false;
    }
}
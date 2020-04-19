package leetcode.array;

/**
 * @description:搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
 * <p>
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * 示例:
 * <p>
 * 现有矩阵 matrix 如下：
 * <p>
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 * <p>
 * 给定 target = 20，返回 false。
 *
 *
 * @author: wangxuanni
 * @create: 2020-04-19 11:24
 **/

public class SearchMatrix {
    public static void main(String[] args) {
        int [][]arr={
                {1,4,7,11,15},
                {2,5,8,12,19},
                {11,12,13,14,15},
                {16,17,18,19,20},
                {21,22,23,24,25}};

        System.out.println(searchMatrix(arr,5));
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length==0||matrix[0].length==0)return false;
        int hang = matrix.length-1;
        int lie = matrix[0].length-1;
        int i = 0;
        int j= 0;
        for (; i <lie; i++) {
            if (matrix[0][i] == target) return true;
            if (matrix[0][i] > target) break;
        }

        for (; j < hang; j++) {
            if (matrix[j][i] == target) return true;
            if (matrix[j][i]>target)break;
        }
        for (; i >0; i--) {
            if (matrix[j][i] == target) return true;
            if (matrix[j][i] <target) break;
        }
        return false;
    }
}

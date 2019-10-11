package leetcode.array;

import java.util.Arrays;

/**
 * @description:
 * @author: wangxuanni
 * @create: 2019-10-11 15:46
 **/

public class MoveZeroes {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if(i!=index){//针对数组没有0这种情况做的优化判断
                int t = nums[i];
                nums[i] = nums[index];
                nums[index++] = t;}else{
                    index++;
                }
            }
        }
    }
}

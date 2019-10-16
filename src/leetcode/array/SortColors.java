package leetcode.array;

import java.util.Arrays;

/**
 * @description: 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 * 一个直观的解决方案是使用计数排序的两趟扫描算法。
 * 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 * @author: wangxuanni
 * @create: 2019-10-11 16:13
 **/

public class SortColors {
    public static void main(String[] args) {
        int[] arr = {2, 0, 2, 1, 1, 0};
        sortColors(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sortColors(int[] nums) {
        int z = -1;
        int t = nums.length - 1;
        int i=0;

        while (i < t) {
            if (nums[i] == 1) {
                i++;
            } else if (nums[i] == 0) {
                swap(nums,i++,z+1);
                z++;
            }else{
                swap(nums,i,t--);
            }
        }
    }

      static  void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
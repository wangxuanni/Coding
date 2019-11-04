package structure;

import java.util.Arrays;

/**
 * @description:区域和检索 - 数组不可修改
 * @author: wangxuanni
 * @create: 2019-11-04 16:33
 **/

public class NumArray {
    public static void main(String[] args) {
      /*  ["NumArray","sumRange","sumRange","sumRange"]
          [[[-2,0,3,-5,2,-1]],[0,2],[2,5],[0,5]]*/
      int[]arr={-2,0,3,-5,2,-1};
        NumArray numArray=new NumArray(arr);
        System.out.println(Arrays.toString(numArray.sum));
        System.out.println(numArray.sumRange(0,2));
        System.out.println(numArray.sumRange(2,5));
        System.out.println(numArray.sumRange(0,5));

    }
    int[] sum;

    public NumArray(int[] nums) {
        sum = new int[nums.length +1];
        sum[0] = 0;
        for (int i = 1; i <sum.length; i++) {
            sum[i] = nums[i - 1] + sum[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j+1] - sum[i];
    }
}

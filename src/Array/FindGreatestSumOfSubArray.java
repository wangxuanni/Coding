package Array;

/**
 * 连续子数组的最大和
 * max的作用是防止 后面是一个负数加上有损利益，但整体和并没有小于负数。
 * 比如当sum=18，max=18，下一个数是-5.如果没有max加入去之后就忘记之前的中间可能会出现的最大值。
 */
public class FindGreatestSumOfSubArray {
    public static int FindGreatestSumOfSubArray(int[] array) {
        if (array.length == 0)
            return 0;
        int sum = array[0], max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (sum >= 0)////之前的和小于零，还不如直接用下一个
                sum += array[i];
            else
                sum = array[i];
            if (sum > max) {//防止后面是一个负数
                max = sum;
            }
        }
        return max;
    }
}

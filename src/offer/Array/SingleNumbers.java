package offer.Array;

/**
 * 数组中数字出现的次数
 * https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/
 * @author wangxuanni
 * @since 2022-02-21 11:37
 **/

public class SingleNumbers {
    public int[] singleNumbers(int[] nums) {
        int sum = 0;
        int m = 1;
        int x=0;
        int y=0;
        //将数组元素相异或，得到数组中两个没重复的数字的和，即x+y
        for (int num : nums) {
            sum ^= num;
        }
        //因为x和y不一样，所以一定有一位二进制不一样
        //从1开始与，每轮1右移一位，直到到二进制位不一样的，结果不等于0
        while ((sum & m) == 0) {
            m = m << 1;
        }
        //用m把数组分为两个数组,与m等于0的数组和与m不等于0的数组
        for (int num : nums) {
            if ((num & m) == 0) x ^= num;
            else y ^= num;
        }
        return new int[]{x, y};
    }
}

package leetcode.orther;

import java.util.Arrays;

/**
 * 会议室
 * @author keyu
 * @since 2022-04-05 22:28
 * 001101
 **/

public class ZeroOne {
    public static void main(String[] args) {
        numberOfWays("001101");
    }
    public static long numberOfWays(String s) {
        int[] array = new int[s.length()];
        int j = 0;
        for (char c : s.toCharArray()) {
            array[j++] = (int) c-'0';
        }
        int oneCount = 0;
        int zeroCount = 0;
        int[] memo = new int[array.length];
        //遍历一遍，记录1的个数
        for (int i = 0; i < array.length; i++) {
            memo[i] = oneCount;

            if (array[i] == 1) {
                oneCount++;
            } else {
                zeroCount++;
            }
        }
        int result = 0;
        int leftCount;
        int rightCount;
        for (int i = 1; i < array.length; i++) {
            if (array[i] == 1) {
                //left zero's nums =(left'index+1)-left one's nums
                leftCount = i - memo[i];
                rightCount = zeroCount - leftCount;
                System.out.println(i);
            } else {
                //left one's nums =
                leftCount = memo[i];
                rightCount = oneCount - leftCount;
            }
            result += leftCount*rightCount;
        }
        return result;
    }
}

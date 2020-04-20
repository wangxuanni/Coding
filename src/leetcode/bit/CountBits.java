package leetcode.bit;

/**
 * @description:
 * @author: wangxuanni
 * @create: 2020-04-20 22:32
 **/

public class CountBits {
    public int[] countBits(int num) {
        int []arr=new int[num+1];
        for (int i =0 ; i <=num; i++) {
            arr[i]= Integer.bitCount(i);
        }
        return arr;

    }
}

package leetcode.bit;

/**
 * @description:输入: x = 1, y = 4
 *
 * 输出: 2
 *
 * 解释:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 * @author: wangxuanni
 * @create: 2020-04-20 22:22
 **/

public class HammingDistance {
    public static void main(String[] args) {

        System.out.println(hammingDistance(1,4));
    }
    public static int hammingDistance(int x, int y) {
        int i = x ^ y;

        int count=0;
        while(i>0){
            i=(i-1)&i;
            count++;
        }
        return count;

    }
}

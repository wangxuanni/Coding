package offer.Array;

/**
 * 构建乘积数组
 *
 * @author keyu
 * @since 2022-03-17 11:58
 **/

public class ConstructArr {
    public int[] constructArr(int[] a) {
        int len = a.length;
        if (len <= 1) return a;
        int[] b = new int[len];
        b[0] = 1;
        for (int i = 1; i < len; i++) {
            //左半边的乘积
            b[i] = b[i - 1] * a[i - 1];
        }
        int temp = 1;
        for (int i = len - 2; i >= 0; i--) {
            //右半边的乘积
            temp *= a[i + 1];
            //右半边和左半边相乘
            b[i] *= temp;

        }
        return b;
    }
}
package leetcode.math;

import java.util.HashSet;

/**
 * 快乐数
 *
 * @author keyu
 * @since 2022-05-20 21:29
 **/

public class IsHappy {
    public boolean isHappy(int n) {
        HashSet set = new HashSet<Integer>();
        int factor = 10;
        int sum = 0;
        while (!set.contains(n)) {
            set.add(n);
            while (n != 0) {
                int number = n % factor;
                sum += number * number;
                n /= factor;
            }
            n = sum;
            sum = 0;
        }
        return n == 1;

    }
}

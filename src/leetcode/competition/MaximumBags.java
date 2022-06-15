package leetcode.competition;

import java.util.Arrays;

/**
 * 5.22周赛第二题
 * @author keyu
 * @since 2022-05-22 10:47
 **/

public class MaximumBags {
    public static void main(String[] args) {
        System.out.println(maximumBags(new int[]{10, 2, 2, 5, 2}, new int[]{0, 0, 0, 0, 0}, 10));
    }

    public static int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int[] dif = new int[capacity.length];
        for (int i = 0; i < capacity.length; i++) {
            dif[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(dif);
        int res = 0;
        for (int i : dif) {
            if (additionalRocks - i< 0) return res;
            additionalRocks = additionalRocks - i;
            res++;
        }
        return res;
    }
}

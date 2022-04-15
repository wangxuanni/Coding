package leetcode.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * 根据身高重建队列
 *
 * @author keyu
 * @since 2022-03-25 10:41
 **/

public class ReconstructQueue {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(final int[] p1, final int[] p2) {
                if (p1[0] != p2[0]) {
                    return p2[0] - p1[0];
                } else {
                    return p1[1] - p2[1];
                }
            }
        });
        LinkedList<int[]> list = new LinkedList<>();
        for (int[] person : people) {
            list.add(person[1], person);

        }
        return list.toArray(new int[0][]);
    }
}
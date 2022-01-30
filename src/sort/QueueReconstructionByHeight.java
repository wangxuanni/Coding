package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author zakree
 * @since 2021-10-02 20:54
 **/

public class QueueReconstructionByHeight {
    public static void main(String[] args) {
        int[][] arr = {
                {7, 0},
                {7, 1},
                {4, 4},
                {5, 0},
                {6, 1},
                {6, 2}};
        int[][] ints = reconstructQueue(arr);
        System.out.println(Arrays.toString(ints));
    }

    public static int[][] reconstructQueue(int[][] people) {

        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0]) {
                    return a[0] - b[0];
                } else {
                    return b[1] - a[1];
                }
            }
        });
        ArrayList<int[]> list = new ArrayList<int[]>();

        for (int i = people.length-1; i >= 0; i--) {
            int insertNum = people[i][1];
            list.add(insertNum, people[i]);
        }
        int[][] arr =new int [people.length][people[0].length];
        for (int i = 0; i < arr.length; i++) {
           arr[i]=list.get(i);

        }
        return arr;

    }

}

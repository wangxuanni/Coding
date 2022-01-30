package cracking.dfs;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author zakree
 * @since 2022-01-13 10:49
 **/

public class PondSizes {
    public static void main(String[] args) {
        int [][]arr={
                {0,2,1,0},
                {0,1,0,1},
                {1,1,0,1},
                {0,1,0,1}};
        System.out.println(arr[0][3]);
        System.out.println(Arrays.toString(pondSizes(arr)));
    }
    public static int[] pondSizes(int[][] land) {
        if (land == null) return null;
        ArrayList<Integer> list = new ArrayList<Integer>();
        int[][] visit = new int[land.length ][land[0].length ];
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                int waterCount = dfs(land, i, j, visit);
                if (waterCount > 0) {
                    list.add(waterCount);
                }

            }

        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;

    }

    public static int dfs(int[][] land, int i, int j, int[][] visit) {
        if (i < 0 || j < 0 || i >= land.length || j >= land[0].length || land[i][j] != 0 || visit[i][j] > 0)
            return 0;

        int waterCount = 1;
        visit[i][j] = 1;
        waterCount += dfs(land, i+1, j, visit);
        waterCount += dfs(land, i-1, j, visit);
        waterCount += dfs(land, i, j+1, visit);
        waterCount += dfs(land, i, j-1, visit);
        return waterCount;
    }
}

package offer.sreach;

import java.util.LinkedList;

/**
 * https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/9h6vo2/
 * bfs解法
 * @author keyu
 * @since 2022-02-10 16:54
 **/

public class MovingCount {
    public static void main(String[] args) {

        System.out.println(movingCount(1, 2, 1));
    }

    public static int movingCount(int m, int n, int k) {

        LinkedList<int[]> arrList = new LinkedList<>();
        boolean[][] visit = new boolean[m][n ];

        int count = 0;
        arrList.add(new int[]{0, 0});

        while (arrList.size() > 0) {
            int[] xy = arrList.getFirst();
            int x = xy[0];
            int y = xy[1];
            if (x >= m || y >= n|| sumFor(x) + sumFor(y) > k || visit[x][y] ) {
                arrList.removeFirst();
                continue;
            }
            count++;
            visit[x][y] = true;
            arrList.add(new int[]{x + 1, y});
            arrList.add(new int[]{x, y + 1});

        }
        return count;
    }

    static int sumFor(int i) {
        int sum = 0;
        int chen = 0;
        while (i > 0) {
            sum += i % 10;
            i = i / 10;
        }
        return sum;

    }
}

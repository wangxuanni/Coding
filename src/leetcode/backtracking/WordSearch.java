package leetcode.backtracking;

import java.util.Arrays;

/**
 * @description:
 * @author: wangxuanni
 * @create: 2019-09-14 15:30
 **/

public class WordSearch {
    static int n;
    static int m;
    private final static int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        char[][] board = {
                { 'B', 'A','B', },};
        String word = "bbabab";
        System.out.println(exist(board, word));
    }


    public static boolean exist(char[][] board, String word) {

        if (board == null || word.length() == 0)
            return true;

        n = board.length;
        m = board[0].length;
        boolean[][] hasV = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (f(board, word, i, j, hasV, 0))
                    return true;
            }

        }
        return false;

    }

    public static boolean f(char[][] board, String word, int c, int r, boolean[][] hasV, int curlen) {
        if (curlen == word.length())
            return true;

       // System.out.println(word.charAt(curlen)+"is ?="+board[c][r]+" curlen:"+curlen);
        if (c < 0 || c >= n || r < 0 || r >= m|| word.charAt(curlen) != board[c][r] || hasV[c][r]) {
            return false;
        }
        hasV[c][r] = true;
        //System.out.println("find" + word.charAt(curlen));

        for (int[] ints : direction) {
            System.out.println(Arrays.toString(ints));
            if (f(board, word, c + ints[0], r + ints[1], hasV, curlen+1)) {
                return true;
            }
        }
        hasV[c][r] = false;
        return false;
    }
}

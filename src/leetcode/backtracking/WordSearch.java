package leetcode.backtracking;

import java.util.Arrays;

/**
 * @description:
 * @author: wangxuanni
 * @create: 2019-09-14 15:30
 **/

public class WordSearch {
    String word;
    char[][] board;
    boolean result = false;
    private final static int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        char[][] board = {
                { 'B', 'A','B', },};
        String word = "bbabab";
        WordSearch wordSearch = new WordSearch();
        System.out.println(wordSearch.exist(board, word));
    }

    public  boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        return dfs("", 0, 0, new boolean[board.length][board[0].length]);
    }


    public boolean dfs(String pre, int hang, int row, boolean[][] visited) {
        //判断
        if (hang < 0 || hang >= board.length
                || row < 0 || row >= board.length
                || visited[hang][row] || board[hang][row] != word.charAt(pre.length())) {
            System.out.println(hang);
            System.out.println(row);
            System.out.println(board[hang][row]);
            System.out.println(pre.length());
            System.out.println(word.charAt(pre.length()));
            return false;
        }
        if (pre.equals(word)) {
            return true;
        }

        for (int i = hang; i < board.length; i++) {
            for (int j = row; j < board[0].length; j++) {
                if (visited[i][j]) continue;
                visited[i][j] = true;

                result = result || dfs(pre, i + 1, j, visited);
                result = result || dfs(pre, i - 1, j, visited);
                result = result || dfs(pre, i, j + 1, visited);
                result = result || dfs(pre, i, j - 1, visited);

                visited[i][j] = false;
            }
        }
        return result;

    }
}
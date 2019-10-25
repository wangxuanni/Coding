package leetcode.backtracking;

/**
 * @description:
 * @author: wangxuanni
 * @create: 2019-10-11 10:02
 **/

public class WordSearch2 {
    public static void main(String[] args) {
        char[][] board = {
                {'B', 'A', 'B',}, {'B', 'A', 'B',}
        };
        String word = "BB";
        System.out.println(exist(board, word));
    }

    private final static int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static int m;
    private static int n;

    public static boolean exist(char[][] board, String word) {
        if (board.length < 1 || word.trim().equals("")) {
            return false;
        }
        m = board.length;
        n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, 0, i, j, visited)) {
                    return true;
                }
            }
        }
        return false;
    }


    public static boolean dfs(char[][] board, String word, int curlen, int i, int j, boolean[][] visited) {
        if (curlen == word.length())
            return true;
        if (i < 0 || i > m || j < 0 || j > n || board[i][j] != word.charAt(curlen) || visited[i][j])
            return false;
        visited[i][j] = true;

        for (int[] ints : direction) {
            if (dfs(board, word, curlen + 1, i + ints[0], j + ints[1], visited))
                return true;
        }
        return false;
    }
}

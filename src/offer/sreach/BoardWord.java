package offer.sreach;

/**
 * @author zakree
 * @since 2022-01-04 10:25
 *
 **/

public class BoardWord {
    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        System.out.println(exist(board, word));
    }

    public static boolean exist(char[][] board, String word) {
        char[] wordArr = word.toCharArray();
        int wordLen = 0;
        for (int iW = 0; iW <= board[0].length; iW++) {
            for (int jW = 0; jW <= board.length; jW++) {
                if (dfs(board, wordArr, 0, jW, iW))
                    return true;
            }
        }
        return false;
    }

    public static boolean dfs(char[][] board, char[] wordArr, int wordLen, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != wordArr[wordLen])
            return false;
        if (wordArr.length - 1 == wordLen)
            return true;
        board[i][j] = '#';
        boolean res = dfs(board, wordArr, wordLen + 1, i + 1, j) || dfs(board, wordArr, wordLen + 1, i, j + 1)
                || dfs(board, wordArr, wordLen + 1, i - 1, j) || dfs(board, wordArr, wordLen + 1, i, j - 1);
        board[i][j] = wordArr[wordLen];
        return res;
    }
}

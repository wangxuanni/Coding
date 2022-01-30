package offer.sreach;

/**
 * @author zakree
 * @since 2022-01-01 17:49
 **/

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int wordLen = 0;
        for (int i = 0; i < board[0].length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (dfs(board, word, 0, i, j))
                    return true;
            }
        }
        return false;
    }

    boolean dfs(char[][] board, String word, int wordLen, int i, int j) {
        if (i < 0 || j < 0 || i >= board[0].length || j >= board.length || board[i][j] != word.charAt(wordLen))
            return false;
        if (word.length() - 1 == wordLen)
            return true;
        board[i][j] = '#';
        boolean res = dfs(board, word, wordLen++, i++, j) || dfs(board, word, wordLen++, i, j++)
                || dfs(board, word, wordLen++, i--, j) || dfs(board, word, wordLen++, i, j--);
        board[i][j] = word.charAt(wordLen);
        return res;

    }
}

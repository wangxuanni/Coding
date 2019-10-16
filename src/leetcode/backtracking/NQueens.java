package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: wangxuanni
 * @create: 2019-10-14 22:17
 **/

public class NQueens {
    private List<List<String>> solutions;
    private char[][] nQueens;
    private boolean[] colUsed;
    private boolean[] arr45;
    private boolean[] arr135;
    private int n;

    public List<List<String>> solveNQueens(int n) {
        solutions = new ArrayList<>();
        nQueens = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(nQueens[i], '.');
        }
        colUsed = new boolean[n];
        arr45 = new boolean[2 * n - 1];
        arr135 = new boolean[2 * n - 1];
        this.n = n;
        backtracking(0);
        return solutions;
    }

    private void backtracking(int row) {
        if (row == n) {
            List<String> list = new ArrayList<>();
            for (char[] chars : nQueens) {
                list.add(new String(chars));
            }
            solutions.add(list);
            return;
        }

        for (int col = 0; col < n; col++) {
            int i45 = row + col;
            int i135 = n - 1 - (row - col);
            if (colUsed[col] || arr45[i45] || arr135[i135]) {
                continue;
            }
            nQueens[row][col] = 'Q';
            colUsed[col] = arr45[i45] = arr135[i135] = true;
            backtracking(row + 1);
            colUsed[col] = arr45[i45] = arr135[i135] = false;
            nQueens[row][col] = '.';
        }
    }
}

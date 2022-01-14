package cracking.dfs;
//给你一个大小为 m x n 的二进制矩阵 grid 。 
//
// 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。你可以假设 grid 的四个边缘都
//被 0（代表水）包围着。 
//
// 岛屿的面积是岛上值为 1 的单元格的数目。 
//
// 计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,
//0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,
//0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
//输出：6
//解释：答案不应该是 11 ，因为岛屿只能包含水平或垂直这四个方向上的 1 。
// 
//
// 示例 2： 
//
// 
//输入：grid = [[0,0,0,0,0,0,0,0]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 50 
// grid[i][j] 为 0 或 1 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 656 👎 0

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author keyu
 * @since 2022-01-13 16:09
 **/

public class MaxAreaOfIsland {
    public static void main(String[] args) {
        int[][] arr = {
                {0, 2, 1, 0},
                {0, 1, 0, 1},
                {1, 1, 0, 1},
                {0, 1, 0, 1}};
        System.out.println(maxAreaOfIsland(arr));
    }

    public static int maxAreaOfIsland(int[][] grid) {

        if (grid == null) return 0;
        int[][] visit = new int[grid.length][grid[0].length];
        int waterCount = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return dfs(grid, i, j, visit);
                }
            }

        }

        return 0;

    }

    public static int dfs(int[][] grid, int i, int j, int[][] visit) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0)
            return 1;
        if (visit[i][j] == 1)
            return 0;

        int waterCount = 0;
        visit[i][j] = 1;
        waterCount += dfs(grid, i + 1, j, visit);
        waterCount += dfs(grid, i - 1, j, visit);
        waterCount += dfs(grid, i, j + 1, visit);
        waterCount += dfs(grid, i, j - 1, visit);
        return waterCount;
    }
}
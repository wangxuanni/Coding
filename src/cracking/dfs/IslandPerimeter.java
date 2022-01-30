package cracking.dfs;

/**
 * @author zakree
 * @since 2022-01-13 16:39
 **/

public class IslandPerimeter {
    public static void main(String[] args) {
        int [][]arr={
                {0,2,1,0},
                {0,1,0,1},
                {1,1,0,1},
                {0,1,0,1}};
        System.out.println(IslandPerimeter(arr));
    }
    public static int IslandPerimeter(int[][] grid) {
        if (grid == null) return 0;
        int[][] visit = new int[grid.length][grid[0].length];
        int waterCount = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return dfs(grid, i, j,visit);
                }
            }

        }

        return 0;

    }

    public static int dfs(int[][] grid, int i, int j,int[][] visit) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0|| visit[i][j] == 1)
            return 1;

        int waterCount = 0;
        visit[i][j] = 1;
        waterCount += dfs(grid, i + 1, j,visit);
        waterCount += dfs(grid, i - 1, j,visit);
        waterCount += dfs(grid, i, j + 1,visit);
        waterCount += dfs(grid, i, j - 1,visit);
        return waterCount;
    }
}

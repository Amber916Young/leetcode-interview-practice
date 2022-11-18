package Matrix;

/**
 * @ClassName:countSubIslands
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/count-sub-islands/
 * @Date: 17/11/2022 13:11
 * @Version: v1.0
 */
public class countSubIslands {
    int count = 0;
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        for (int i = 0; i < grid1.length; i++) {
            for (int j = 0; j < grid1[0].length; j++) {
                if (grid2[i][j] == 1) {
                    if (grid1[i][j] != 1) {
                        countSubIslands_DFS(grid2, i, j);
                    }
                }
            }
        }
        for (int i = 0; i < grid2.length; i++) {
            for (int j = 0; j < grid2[0].length; j++) {
                if (grid2[i][j] == 1) {
                    count++;
                    countSubIslands_DFS(grid2, i, j);
                }
            }
        }
        return count;
    }

    private void countSubIslands_DFS(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
            return;
        }
        grid[i][j] = 0;
        countSubIslands_DFS(grid, i, j - 1);
        countSubIslands_DFS(grid, i, j + 1);
        countSubIslands_DFS(grid, i - 1, j);
        countSubIslands_DFS(grid, i + 1, j);
    }

}

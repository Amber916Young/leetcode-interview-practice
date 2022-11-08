package Matrix;

/**
 * @ClassName:colorBorder
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/coloring-a-border/
 * @Date: 07/11/2022 12:00
 * @Version: v1.0
 */
public class colorBorder {


    /**
     * [1,1,1],
     * [1,1,1],
     * [1,1,1]
     * @param grid
     * @param row
     * @param col
     * @param color
     * @return
     */
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int org = grid[row][col];
        colorBorder_DFS(row,col,grid,org);
        for(int i =0;i<grid.length;i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] < 0) grid[i][j] = color;
            }
        }
        return grid;
    }

    private void colorBorder_DFS(int row_i, int col_j, int[][] grid, int org) {
        int col = grid[0].length;
        int row = grid.length;
        if (col_j < 0 || col_j >= col || row_i < 0 || row_i >= row || grid[row_i][col_j] != org) return;
        grid[row_i][col_j] = -org;
        colorBorder_DFS(row_i + 1, col_j, grid, org);
        colorBorder_DFS(row_i - 1, col_j, grid, org);
        colorBorder_DFS(row_i, col_j + 1, grid, org);
        colorBorder_DFS(row_i, col_j - 1, grid, org);

        if (colorBorder_DFS_abs(grid, row_i + 1, col_j,org) && colorBorder_DFS_abs(grid, row_i - 1, col_j,org)
                && colorBorder_DFS_abs(grid, row_i, col_j + 1,org) && colorBorder_DFS_abs(grid, row_i, col_j - 1,org)) {
            grid[row_i][col_j] = org;
        }

    }

    private boolean colorBorder_DFS_abs(int[][] grid, int row_i, int col_j,int org) {
        int col = grid[0].length;
        int row = grid.length;
        if (col_j < 0 || col_j >= col || row_i < 0 || row_i >= row ) return false;

       if(grid[row_i][col_j]  ==org ||grid[row_i][col_j]  == -org  ) return true;
       return false;
    }
}

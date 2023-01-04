package Mock;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @ClassName:orangesRotting
 * @Auther: yyj
 * @Description:
 * @Date: 04/01/2023 14:32
 * @Version: v1.0
 */
public class orangesRotting {
    public static void main(String[] args) {
        orangesRotting test = new orangesRotting();
        test.orangesRotting(new int[][]{{2,1,1},{1,1,0},{0,1,1}});
    }
    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        int day = -1;

        Queue<int[]> queue = new ArrayDeque<>();
        for (int i =  0; i < row  ; i++) {
            for (int j = 0; j < col  ; j++) {
                if (grid[i][j] == 2) queue.offer(new int[]{i, j , 2});
                if(grid[i][j] == 0) count++;
            }
        }
        if(count == row * col) return 0;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int[] dir : dirs) {
                    int ro = dir[0] + cur[0];
                    int co = dir[1] + cur[1];
                    if (ro < 0 || co < 0 || ro >= row || co >= col || grid[ro][co] == 0) continue;
                    if (grid[ro][co] == 1) {
                        queue.offer(new int[]{ro, co});
                        grid[ro][co] = 2;

                    }
                }
            }
            day++;
        }
        for (int i = 0; i < row  ; i++) {
            for (int j = 0; j < col  ; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return day;

    }

    private void orangesRotting_DFS(int[][] grid, int i, int j, int day) {
        int row = grid.length;
        int col = grid[0].length;
        if(i < 0 || j<0 || i >= row||j >= col || grid[i][j] == 0 || grid[i][j] == 2){
            return;
        }
        grid[i][j] = 2;
//        day ++;
        orangesRotting_DFS(grid,i-1,j,day ++ );
        orangesRotting_DFS(grid,i,j-1,day ++ );
        orangesRotting_DFS(grid,i+1,j,day ++);
        orangesRotting_DFS(grid,i,j+1,day++ );
    }
}

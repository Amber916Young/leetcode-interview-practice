package Matrix;

import java.util.*;

/**
 * @ClassName:orangesRotting994
 * @Auther: yyj
 * @Description:
 * @Date: 17/11/2022 15:49
 * @Version: v1.0
 */
public class orangesRotting994 {
    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        boolean entry = false;
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < row && !entry; i++) {
            for (int j = 0; j < col && !entry; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j , 2});
                }
                if(grid[i][j] == 0) count++;
            }
        }
        if(count == row * col) return 0;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int days = -1;
        while (!queue.isEmpty()) {
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
            days++;
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col ; j++) {
                if (grid[i][j] == 1) {
                    return  -1;
                }
            }
        }
        return days;
    }
}

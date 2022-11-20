package Matrix;

import java.util.*;

/**
 * @ClassName:nearestExit
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/
 * @Date: 18/11/2022 14:34
 * @Version: v1.0
 */
public class nearestExit {

    public int nearestExit(char[][] maze, int[] entrance) {
        int row = maze.length;
        int col = maze[0].length;
        int count = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(entrance);
        boolean[][] visited = new boolean[row][col];
        int dirs[][] = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        visited[entrance[0]][entrance[1]] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                for (int[] dir : dirs) {
                    int cur_row = dir[0] + curr[0];
                    int cur_col = dir[1] + curr[1];

                    if (cur_row >= 0
                            && cur_row < row
                            && cur_col >= 0
                            && cur_col < col
                            && !visited[cur_row][cur_col]
                            && maze[cur_row][cur_col] == '.') {
                        if (cur_row == 0 || cur_col == 0 || cur_row == row - 1 || cur_col == col - 1) {
                            return count;
                        }
                        queue.offer(new int[]{cur_row, cur_col});

                        visited[cur_row][cur_col] = true;
                    }
                }
            }
        }
        return -1;
    }
}

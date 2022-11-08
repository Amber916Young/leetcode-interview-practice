package Matrix;

/**
 * @ClassName:gridGame
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/grid-game/
 * @Date: 07/11/2022 14:11
 * @Version: v1.0
 */
public class gridGame {

    public static void main(String[] args) {
        gridGame(new int[][]{{2,5,4},{1,5,1}});
    }
    static public long gridGame(int[][] grid) {
        long min = Long.MAX_VALUE;  // maxScore Collected by Robot2
        int m = grid[0].length;
        long t1 = 0;
        for (int x : grid[0])
            t1 += x;
        long s1 = 0;
        long s2 = 0;
        for (int i = 0; i < m; i++) {
            s1 += grid[0][i];
            long score = Math.max(t1 - s1, s2);
            s2 += grid[1][i];
//            min = Math.min(score,min);
            if(score < min) min = score;

        }

        return min;
    }
}

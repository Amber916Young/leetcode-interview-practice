package Matrix2DArray;

import java.util.Arrays;

/**
 * @ClassName:minFallingPathSum
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/minimum-falling-path-sum/
 * @Date: 30/10/2022 12:29
 * @Version: v1.0
 */
public class minFallingPathSum {

    int[][] dp;
    public int minFallingPathSum(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        dp=new int[rows][cols];
        for(int[] i: dp){
            Arrays.fill(i, -1);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < cols; i++) {
            min=Math.min(min, DFS_minFallingPathSum(matrix,0,i ));
        }
        return min;
    }
    public int DFS_minFallingPathSum(int[][] matrix,int row,int col){
        int rows = matrix.length, cols = matrix[0].length;
        if (row < 0 || row >= rows || col < 0 || col >= cols ) return Integer.MAX_VALUE;
        if(row == matrix.length-1) return matrix[row][col];

        if(dp[row][col] != -1) return dp[row][col];
        int left=DFS_minFallingPathSum(matrix,row+1,col-1);
        int mid= DFS_minFallingPathSum(matrix,row+1,col);
        int right= DFS_minFallingPathSum(matrix,row+1,col+1);

        dp[row][col] = matrix[row][col]+Math.min(left, Math.min(mid, right));


        return dp[row][col];
    }
}

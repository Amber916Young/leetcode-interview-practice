package Matrix;

/**
 * @ClassName:maxSum
 * @Auther: yyj
 * @Description: 2428. Maximum Sum of an Hourglass
 * @Date: 20/12/2022 15:02
 * @Version: v1.0
 */
public class maxSum {



    public int maxSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int sum = 0;
        for(int i =0;i< row -2 ;i++){
            for(int j =0;j< col - 2 ;j++){
                int count = 0;
                count = grid[i][j] + grid[i][j + 1] + grid[i][j + 2] + grid[i + 1][j + 1]
                        + grid[i + 2][j] + grid[i + 2][j + 1] + grid[i + 2][j + 2];
                sum = Math.max(sum,count);
            }
        }
        return sum;
    }


}

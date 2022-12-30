package Matrix;

/**
 * @ClassName:matrixScore
 * @Auther: yyj
 * @Description:
 * @Date: 20/12/2022 14:32
 * @Version: v1.0
 */
public class matrixScore {
    public static void main(String[] args) {
        int[][] ins =  new int[][]{{0,0,1,1},{1,0,1,0},{1,1,0,0}};
        matrixScore(ins);
    }

    public static int matrixScore(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        for (int i = 0; i < row; i++) {
            reverse(grid[i]);
        }

        int res=0;
        for(int i = col-1;i>=0;i--){
            int sum=0;
            for(int j=0;j<row;j++){
                sum+=grid[j][i];
            }
            if(sum <= row/2){
                reverse2(grid,i);
            }
        }

        for (int i = 0; i < row; i++) {
            int index = 0;
            for (int j = col - 1; j >= 0; j--) {
                if(grid[i][j] == 1){
                    res += Math.pow(2,index);
                }
                index++;
            }
        }
        return res;
    }

    static private void reverse2(int[][] grid, int col) {
        for (int i = 0; i < grid.length; i++) {
            grid[i][col] = grid[i][col]== 0 ? 1:0;
        }
    }
    static private void reverse(int[] arr) {
        if (arr[0] == 0) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = arr[i] == 0 ? 1:0;
            }
        }
    }
}

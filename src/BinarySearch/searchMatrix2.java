package BinarySearch;

/**
 * @ClassName:searchMatrix2
 * @Auther: yyj
 * @Description:
 * @Date: 18/11/2022 14:31
 * @Version: v1.0
 */
public class searchMatrix2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row =0;
        int col =matrix[0].length-1;
        while(row <matrix.length && col>=0){
            if(matrix[row][col] == target){
                return true;
            }else if(matrix[row][col] > target){
                col--;
            }else{
                row++;
            }
        }
        return false;
    }
}

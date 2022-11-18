package BinarySearch;

/**
 * @ClassName:searchMatrix
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/search-a-2d-matrix/
 * @Date: 18/11/2022 14:03
 * @Version: v1.0
 */
public class searchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int column = matrix[0].length;
        int layer = 0;
        for (int i = 0; i < row; i++) {
            int start = matrix[i][0];
            int end = matrix[i][column - 1];
            if (target >= start && target <= end) {
                layer = i;
                break;
            }
        }
        int[] arr = matrix[layer];
        int start = 0;
        int end = arr.length;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == arr[mid]) return true;
            if (arr[mid] > target) end = mid - 1;
            else {
                start = mid + 1;
            }
        }
        return false;
    }
    public boolean searchMatrix1_bad(int[][] matrix, int target) {
        int row = matrix.length;
        int column = matrix[0].length;
        int layer = 0;
        for(int i=0;i<row;i++){
            int start=matrix[i][0];
            int end=matrix[i][column-1];
            if(target>=start && target<=end){
                layer = i;
                break;
            }
        }
        for(int i=0;i<column;i++){
            if(target==matrix[layer][i]) return true;
        }
        return false;
    }
}

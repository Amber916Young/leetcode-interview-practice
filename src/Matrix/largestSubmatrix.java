package Matrix;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName:largestSubmatrix
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/largest-submatrix-with-rearrangements/
 * @Date: 17/11/2022 13:20
 * @Version: v1.0
 */
public class largestSubmatrix {
    public static void main(String[] args) {

        largestSubmatrix(new int[][]
                {{0,0,1},{1,1,1},{1,0,1}}
                );
    }

   static public int largestSubmatrix(int[][] matrix) {
       int row = matrix.length;
       int col = matrix[0].length;
       int maxArea = 0;
       for (int i = 0; i < row; i++) {
           PriorityQueue<Integer> MaxHeap = new PriorityQueue<>(Collections.reverseOrder());
           for (int j = 0; j < col; j++) {
               if (matrix[i][j] == 1) {
                   if (i > 0) matrix[i][j] += matrix[i - 1][j];
                   MaxHeap.add(matrix[i][j]);
               }
           }
           int minColHeight = 0;
           int width = 0;
           while (!MaxHeap.isEmpty()) {
               width++;
               minColHeight = MaxHeap.poll();
               maxArea = Math.max(minColHeight * width, maxArea);
           }
       }
       return maxArea;
   }
}

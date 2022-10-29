package BinarySearch;

import java.util.PriorityQueue;

/**
 * @ClassName:kWeakestRows
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/
 * @Date: 27/10/2022 23:41
 * @Version: v1.0
 */
public class kWeakestRows {
    /**
     * [[1,1,0,0,0],
     *  [1,1,1,1,0],
     *  [1,0,0,0,0],
     *  [1,1,0,0,0],
     *  [1,1,1,1,1]],
     *
     * **/
    public static void main(String[] args) {
        kWeakestRows(new int[][]{{1,1,0,0,0},
                {1,1,1,1,0},
                {1,0,0,0,0},
                {1,1,0,0,0},
                {1,1,1,1,1}},3);
    }

    public static int[] kWeakestRows(int[][] mat, int k) {
        int row = mat.length;
        int column = mat[0].length;
        int[] res = new int[k];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0] == b[0] ? b[1] - a[1] : b[0]-a[0]);

        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);

        for (int i = 0; i < row; i++) {
            int count = 0;
            for (int j = 0; j < column; j++) {
                if (mat[i][j] == 1) count++;
            }
            minHeap.offer(new int[]{count, i});
            q.offer(new int[]{count, i});
        }
        int[] ress = new int[k];
        for(int i = 0; i < k; i++) {
            ress[i] = q.remove()[1];
        }

        while (minHeap.size() > k){
            minHeap.poll();
        }
        while (!minHeap.isEmpty()){
            res[--k] = minHeap.poll()[1];
        }

        return res;
    }
}

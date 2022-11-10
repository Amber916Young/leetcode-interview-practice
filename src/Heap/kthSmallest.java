package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName:kthSmallest
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
 *
 * @Date: 10/11/2022 10:54
 * @Version: v1.0
 */
public class kthSmallest {

    public int kthSmallest2(int[][] matrix, int k) {
        int n = matrix.length;
        if (n == 1 && k == 1) return matrix[0][0];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = matrix[i][j];
                minHeap.offer(tmp);
                while (minHeap.size()>k) minHeap.poll();
            }
        }
        return minHeap.peek();
    }
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        if (n == 1 && k == 1) return matrix[0][0];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = matrix[i][j];
                minHeap.offer(tmp);
            }
        }
        int kth = 0;
        for(int i = 0;i<k;i++){
            kth = minHeap.poll();
        }
        return kth;
    }
}

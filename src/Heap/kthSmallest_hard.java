package Heap;

import java.util.*;

/**
 * @ClassName:kthSmallest_hard
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/find-the-kth-smallest-sum-of-a-matrix-with-sorted-rows/
 * @Date: 11/11/2022 10:52
 * @Version: v1.0
 */
public class kthSmallest_hard {
    public static void main(String[] args) {
        kthSmallest(new int[][]{{1,10,10},{1,4,5},{2,3,6}},7);
    }


   static public int[] kthSmallest_reorder(int[] num1,int[] num2, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ?o1[2] -o2[2] : o1[0] -o2[0];
            }
        });
        for(int i = 0;i<num1.length && i < k;i++) {
            for (int j = 0; j < num2.length && j < k; j++) {
                int sum = num1[i] + num2[j];
                minHeap.offer(new int[]{sum, num1[i], num2[j]});
            }
        }
        List<Integer> res = new ArrayList<>();
        while (!minHeap.isEmpty()){
            res.add(minHeap.poll()[0]);
        }
       return res.stream().mapToInt(i -> i).toArray();
    }
    static public int kthSmallest(int[][] mat, int k) {
        int n = mat.length;
        int[] row = mat[0];
        for (int i = 1; i < n; i++) {
            row = kthSmallest_reorder(row, mat[i], k);
        }
        return row[k - 1];
    }
}

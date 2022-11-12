package Heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @ClassName:kthSmallestPrimeFraction
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/k-th-smallest-prime-fraction/
 * @Date: 10/11/2022 21:22
 * @Version: v1.0
 */
public class kthSmallestPrimeFraction {

    //Input: arr = [1,2,3,5], k = 3
    //Output: [2,5]
    //Explanation: The fractions to be considered in sorted order are:
    //1/5, 1/3, 2/5, 1/2, 3/5, and 2/3.
    //The third fraction is 2/5.
    public static void main(String[] args) {
        kthSmallestPrimeFraction(new int[]{1,2,3,5},3);
    }
    static public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;

        PriorityQueue<int[]> maxheap = new PriorityQueue<>(k, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                double k1 = (double)o1[0]/o1[1];
                double k2 = (double)o2[0]/o2[1];
                return (k1 > k2) ? -1 : 1;
            }
        });

        for(int i=0;i<n;i++){
            for(int j= i + 1;j<n;j++){
                maxheap.offer(new int[]{arr[i],arr[j]});
                if(maxheap.size() > k) maxheap.poll();
            }
        }

        return maxheap.peek();
    }
}

package Heap;

import java.util.PriorityQueue;

/**
 * @ClassName:maximumProduct
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/maximum-product-after-k-increments/
 * @Date: 12/11/2022 12:12
 * @Version: v1.0
 */
public class maximumProduct {
    public static void main(String[] args) {
        maximumProduct(new int[]{24,5,64,53,26,38},56);
    }

   static public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int mod = 1000000007;
       for(int a: nums)  minHeap.add(a);
        long sum = 1;
        while (k-- != 0){
            minHeap.offer(minHeap.poll() +1);
        }
        while (!minHeap.isEmpty()){
            sum *= minHeap.poll() % mod  ;
            sum %= mod;
        }
        return (int)sum;
    }
}

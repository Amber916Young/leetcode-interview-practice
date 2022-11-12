package Heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName:maxSubsequence
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/find-subsequence-of-length-k-with-the-largest-sum/
 * @Date: 11/11/2022 23:42
 * @Version: v1.0
 */
public class maxSubsequence {


    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(k, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for(int i =0;i<nums.length;i++){
            if(minHeap.size()>=k&& minHeap.peek()[0] >nums[i] ) continue;

            minHeap.offer(new int[]{nums[i],i});
            if(minHeap.size()>k) minHeap.poll();
        }

        int[] ans = new int[nums.length];
        Arrays.fill(ans,Integer.MAX_VALUE);
        while (!minHeap.isEmpty()){
            int[] tmp = minHeap.poll();
            ans[tmp[1]] = tmp[0];
        }
        int[] res = new int[k];
        int index= 0;
        for(int i =0;i<ans.length;i++){
            if(ans[i] != Integer.MAX_VALUE){
                res[index++] = ans[i];
            }
        }
        return ans;

    }
}

package Heap;

import java.util.*;

/**
 * @ClassName:kSmallestPairs
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
 * @Date: 10/11/2022 15:06
 * @Version: v1.0
 */
public class kSmallestPairs {

    public static void main(String[] args) {
        kSmallestPairs(new int[]{1,7,11},new int[]{2,4,6},3);
    }
    /**
     * Example 1:
     *
     * Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
     * Output: [[1,2],[1,4],[1,6]]
     * Explanation: The first 3 pairs are returned from the sequence: [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
     * Example 2:
     *
     * Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
     * Output: [[1,1],[1,1]]
     * Explanation: The first 2 pairs are returned from the sequence: [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
     * Example 3:
     *
     * Input: nums1 = [1,2], nums2 = [3], k = 3
     * Output: [[1,3],[2,3]]
     * Explanation: All possible pairs are returned from the sequence: [1,3],[2,3]
     * @param nums1
     * @param nums2
     * @param k
     * @return
     */
    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] == b[0] ? b[1]-a[1]:b[0] -a[0];
            }
        });
        int n = nums1.length;
        int m = nums2.length;
        for(int i =0 ;i<n;i++) {
            for (int j = 0; j < m; j++) {
                int sum = nums1[i] + nums2[j];
                if (maxHeap.size() >= k && maxHeap.peek()[0] < sum)  {
                    //当前sum 大于 队顶sum，要找最小值，所以跳过不合符条件的值
                    break;
                }
                maxHeap.add(new int[]{sum, nums1[i], nums2[j]});
                if (maxHeap.size() > k) {
                    maxHeap.poll();
                }

            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        int ind = 0;
        while (!maxHeap.isEmpty()) {
            int[] vals = maxHeap.poll();
            List<Integer> list = new ArrayList<>();
            list.add(vals[1]);
            list.add(vals[2]);
            ans.add(list);
        }
        return ans;
    }
}

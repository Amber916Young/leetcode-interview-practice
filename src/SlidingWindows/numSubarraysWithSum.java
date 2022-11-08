package SlidingWindows;

import java.util.*;

/**
 * @ClassName:numSubarraysWithSum
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/binary-subarrays-with-sum/
 * @Date: 07/11/2022 21:14
 * @Version: v1.0
 */
public class numSubarraysWithSum {

    public static void main(String[] args) {
        numSubarraysWithSum(new int[]{0,0,0,0,0},0);
    }
    /**
     * Input: nums = [1,0,1,0,1], goal = 2
     * Output: 4
     * Explanation: The 4 subarrays are bolded and underlined below:
     * [1,0,1,0,1]
     * [1,0,1,0,1]
     * [1,0,1,0,1]
     * [1,0,1,0,1]
     * @param nums
     * @param goal
     * @return
     */
    static public int numSubarraysWithSum(int[] nums, int goal) {
        if (nums == null || nums.length == 0) return 0;
        // key: prefix sum value, value: count of key that have been seen so far
        Map<Integer, Integer> counter = new HashMap<>();
        int sum = 0;
        int ans = 0;
        counter.put(0, 1);  // don't forget this trivial case
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int target = sum - goal;
            ans += counter.getOrDefault(target, 0);
            counter.put(sum, counter.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }

}

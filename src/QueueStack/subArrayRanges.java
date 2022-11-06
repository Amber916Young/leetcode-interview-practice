package QueueStack;

import java.util.Stack;

/**
 * @ClassName:subArrayRanges
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/sum-of-subarray-ranges/
 * @Date: 05/11/2022 11:14
 * @Version: v1.0
 */
public class subArrayRanges {

    public static void main(String[] args) {
        subArrayRanges(new int[]{1,2,3});
    }

    /**
     * Input: nums = [1,2,3]
     * Output: 4
     * Explanation: The 6 subarrays of nums are the following:
     * [1], range = largest - smallest = 1 - 1 = 0
     * [2], range = 2 - 2 = 0
     * [3], range = 3 - 3 = 0
     * [1,2], range = 2 - 1 = 1
     * [2,3], range = 3 - 2 = 1
     * [1,2,3], range = 3 - 1 = 2
     * So the sum of all ranges is 0 + 0 + 0 + 1 + 1 + 2 = 4.*/

    // stack method O(n)
   static public long subArrayRanges(int[] nums) {
        int n = nums.length;
        long answer = 0;
        Stack<Integer> stack = new Stack<>();
        // Find the sum of all the minimum.
        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() && (i == n || nums[stack.peek()] >= nums[i])) {
                int mid = stack.peek();
                stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek();
                answer -= (long) nums[mid] * (i - mid) * (mid - left);
            }
            stack.add(i);
        }

        // Find the sum of all the maximum.
        stack.clear();
        for (int right = 0; right <= n; ++right) {
            while (!stack.isEmpty() && (right == n || nums[stack.peek()] <= nums[right])) {
                int mid = stack.peek();
                stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek();
                answer += (long)nums[mid] * (right - mid) * (mid - left);
            }
            stack.add(right);
        }
        return answer;
    }
    // BF method O(n^2)
    public long subArrayRanges2(int[] nums) {
        int n = nums.length;
        long answer = 0;
        for (int i = 0; i < n; i++) {
            int minVal = nums[i], maxVal = nums[i];
            for (int j = i; j < n; ++j) {
                minVal = Math.min(minVal, nums[j]);
                maxVal = Math.max(maxVal, nums[j]);
                answer += maxVal - minVal;
            }
        }
        return answer;
    }
}

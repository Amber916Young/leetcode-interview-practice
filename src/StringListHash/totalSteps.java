package StringListHash;

import java.util.*;

/**
 * @ClassName:totalSteps
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/steps-to-make-array-non-decreasing/
 * @Date: 06/11/2022 20:55
 * @Version: v1.0
 */
public class totalSteps {

    public static void main(String[] args) {
        totalSteps(new int[]{5,3,4,4,7,3,6,11,8,5,11});
    }
    /**
     *  Input: nums = [5,3,4,4,7,3,6,11,8,5,11]
     *  Output: 3
     *  Explanation: The following are the steps performed:
     *  - Step 1: [5,3,4,4,7,3,6,11,8,5,11] becomes [5,4,4,7,6,11,11]
     *  - Step 2: [5,4,4,7,6,11,11] becomes [5,4,7,11,11]
     *  - Step 3: [5,4,7,11,11] becomes [5,7,11,11]
     *  [5,7,11,11] is a non-decreasing array. Therefore, we return 3.
     * @param nums
     * @return
     *
     * You are given a 0-indexed integer array nums.
     * In one step, remove all elements nums[i] where nums[i - 1] > nums[i] for all 0 < i < nums.length.
     */

   static public int totalSteps(int[] nums) {
       int res = 0;
       int n = nums.length;

       Stack<int[]> stack = new Stack<>(); // int[]{value, deleteCount}
       int maxValue = nums[0];
       for (int i = 0; i < n; i++) {
           if (nums[i] >= maxValue) {
               maxValue = nums[i];
               stack = new Stack<>();
               continue;
           }
           int max = 1;
           while (!stack.empty() && stack.peek()[0] <= nums[i]) {
               max = Math.max(max, 1 + stack.pop()[1]);
           }
           res = Math.max(res, max);
           stack.push(new int[]{nums[i], max});
       }
       return res;

    }
}

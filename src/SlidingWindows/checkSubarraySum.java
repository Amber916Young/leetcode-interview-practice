package SlidingWindows;

import java.util.*;

/**
 * @ClassName:checkSubarraySum
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/continuous-subarray-sum/
 * @Date: 08/11/2022 13:55
 * @Version: v1.0
 */
public class checkSubarraySum {

    public static void main(String[] args) {
        checkSubarraySum(new int[]{23,2,4,6,6},7);
    }
    //523. Continuous Subarray Sum

    /**
     * Input: nums = [23,2,4,6,7], k = 6
     * Output: true
     * Explanation: [2, 4] is a continuous subarray of size 2 whose elements sum up to 6.
     * @param nums
     * @param k
     * @return
     */
    static public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer,Integer> mp = new HashMap<>();
        mp.put(0,-1);
        int sum = 0;
        for(int i = 0;i < nums.length;i++){
            sum += nums[i];
            int r = sum % k;
            if(!mp.containsKey(r)) mp.put(r,i);
            else if(i - mp.get(r) > 1) return true;
        }
        return false;

    }
}

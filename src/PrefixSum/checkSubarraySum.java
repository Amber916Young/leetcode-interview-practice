package PrefixSum;

import java.util.*;

/**
 * @ClassName:checkSubarraySum
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/continuous-subarray-sum/
 * @Date: 07/11/2022 14:21
 * @Version: v1.0
 */
public class checkSubarraySum {
    public static void main(String[] args) {
        checkSubarraySum(new int[]{23,2,4,6,6},7);
    }

    /**
     * [23,2,4,6,6]
     * 7
     * @param nums
     * @param k
     * @return
     */

    static public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        int sum = 0;
        hashMap.put(0,0);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int mod = sum % k;
            if (!hashMap.containsKey(mod))
                hashMap.put(mod, i + 1);
            else if (hashMap.get(mod) < i)
                return true;
        }
        return false;
    }
}

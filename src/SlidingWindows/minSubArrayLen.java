package SlidingWindows;

import java.util.Map;

/**
 * @ClassName:minSubArrayLen
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/minimum-size-subarray-sum/
 * @Date: 08/11/2022 11:56
 * @Version: v1.0
 */
public class minSubArrayLen {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, len = nums.length, ans = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            while (sum >= target) {
                int windows_size = i - left + 1;
                ans = Math.min(ans, windows_size);
                sum -= nums[left++];
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}

package BinarySearch;

import java.util.Arrays;

/**
 * @ClassName:minimizeArrayValue
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/minimize-maximum-of-array/
 * @Date: 16/11/2022 11:13
 * @Version: v1.0
 */
public class minimizeArrayValue {

    public int minimizeArrayValue(int[] nums) {
        int start = 0;
        int end = (int) 1e9;
        int ans = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isPossible(mid, nums)) {
                end = mid - 1;
                ans = mid;
            } else {
                start = mid + 1;
            }
        }
        return  ans;
    }

    private boolean isPossible(int target, int[] nums) {
        if (nums[0] > target) return false;
        long diff = target - nums[0];
        for (int i = 1; i < nums.length; i++) {
            int d1 = nums[i] - target;
            if (nums[i] <= target) {
                diff -= d1;
                continue;
            }
            if (d1 > diff) return false;
            diff -= d1;
        }
        return true;
    }
}

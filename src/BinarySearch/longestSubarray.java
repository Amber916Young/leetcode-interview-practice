package BinarySearch;

/**
 * @ClassName:longestSubarray
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/
 * @Date: 14/11/2022 21:45
 * @Version: v1.0
 */
public class longestSubarray {

    public int longestSubarray(int[] nums) {
        int j = 0;
        int k = 1;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) k--;
            while (k < 0) {
                if (nums[j] == 0) k++;
                j++;
            }
            res = Math.max(res, i - j);
        }
        return res;
    }
}

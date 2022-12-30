package StringListHash;

import java.util.Arrays;

/**
 * @ClassName:findLHS
 * @Auther: yyj
 * @Description: 594. Longest Harmonious Subsequence
 * https://leetcode.com/problems/longest-harmonious-subsequence/
 * @Date: 26/12/2022 16:21
 * @Version: v1.0
 */
public class findLHS {


    public static void main(String[] args) {
        findLHS(new int[]{1,3,2,2,5,2,3,7});
    }
    /**
     * Input: nums = [1,3,2,2,5,2,3,7]
     * Output: 5
     * Explanation: The longest harmonious subsequence is [3,2,2,2,3].
     *
     * [1,2,2,2,3,3,5,7,9,10]
     */
     static public int findLHS(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        int left = 0;
        int right = left + 1;
        while (right < nums.length && left < nums.length){
            while( nums[right] - nums[left] > 1){
                left++;
            }
            if( nums[right] - nums[left] == 1){
                count = Math.max(count, (right - left) + 1);
            }
            right++;
        }

        return count;

    }
}

package BinarySearch;

/**
 * @ClassName:findMaxConsecutiveOnes
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/max-consecutive-ones/
 * @Date: 14/11/2022 19:45
 * @Version: v1.0
 */


public class findMaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        int k = 0;
        int j = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) k--;
            while (k < 0) {
                if (nums[j] == 0) k++;
                j++;
            }
            res = Math.max(res, i - j + 1);
        }
        return res;
    }
}

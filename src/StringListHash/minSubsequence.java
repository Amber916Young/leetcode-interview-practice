package StringListHash;

import java.util.*;

/**
 * @ClassName:minSubsequence
 * @Auther: yyj
 * @Description:
 * @Date: 21/12/2022 22:35
 * @Version: v1.0
 */
public class minSubsequence {

    /**
     * Input: nums = [4,4,7,6,7]
     * Output: [7,7,6]
     * @param nums
     * @return
     *
     * 4,4,6,7,7
     */
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, sum = 0, count = 0;
        for (int i : nums) {
            sum += i;
        }

        List<Integer> res = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            count += nums[i];
            res.add(nums[i]);
            if (count > sum - count) {
                return res;
            }
        }
        return new ArrayList<>();

    }
}

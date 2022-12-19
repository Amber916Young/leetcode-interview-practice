package StringListHash;

import java.util.Arrays;

/**
 * @ClassName:numberOfArithmeticSlices
 * @Auther: yyj
 * @Description: 413. Arithmetic Slices
 * @Date: 19/12/2022 15:20
 * @Version: v1.0
 */
public class numberOfArithmeticSlices {
    public static void main(String[] args) {
    }

    static public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }
        int differ = nums[1] - nums[0];
        int cnt = 0;
        int ans = 0;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == differ) {
                cnt++;
            } else {
                differ = nums[i] - nums[i - 1];
                cnt = 0;
                continue;
            }
            ans += cnt;

        }
        return ans;
    }
}

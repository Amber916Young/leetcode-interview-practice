package StringListHash;

import java.util.Arrays;

/**
 * @ClassName:threeSumClosest
 * @Auther: yyj
 * @Description:
 * @Date: 09/11/2022 21:33
 * @Version: v1.0
 */
public class threeSumClosest {

    public static void main(String[] args) {
        threeSumClosest(new int[]{-1,2,1,-4},1);
    }
    static public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minAns =0;
        int minGap = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // 去重
            int l = i+1;
            int r = nums.length - 1;
            while (l < r) {
                int sum3_closes = nums[i] + nums[l] + nums[r];
                int gap = Math.abs(sum3_closes - target);
                if (gap < minGap) {
                    minGap = gap;
                    minAns = sum3_closes;
                }
                if (sum3_closes < target) {  //sum 大于 target
                    l++;
                } else r--;
            }
        }
        return minAns;
    }
}

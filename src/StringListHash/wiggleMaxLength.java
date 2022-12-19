package StringListHash;

import java.util.Map;

/**
 * @ClassName:wiggleMaxLength
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/wiggle-subsequence/
 * @Date: 18/12/2022 16:18
 * @Version: v1.0
 */
public class wiggleMaxLength {


    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1) return nums.length;
        int f1 = 0;
        int f2 = 0;
        for (int i =1;i<nums.length;i++){
            if(   nums[i]  > nums[i-1]){
                f1 = f2 +1;
            }else {
                f2 = f1 +1;
            }
        }
        return Math.max(f1,f2) +1;

    }
}

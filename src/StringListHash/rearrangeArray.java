package StringListHash;

import java.util.*;

/**
 * @author birdyyoung
 * @ClassName:rearrangeArray
 * @Description: https://leetcode.com/problems/rearrange-array-elements-by-sign/
 * @Date: 18/12/2022 14:17
 * @Version: v1.0
 */
public class rearrangeArray {


    /**
     * 3,1,-2,-5,2,-4
     * @param nums
     * @return
     */
    public int[] rearrangeArray(int[] nums) {

        int[] ans = new int[nums.length];
        int f1 = 0;
        int f2 = f1 + 1;
        for(int n : nums){
            if(n >= 0){
                ans[f1] = n;
                f1 += 2;
            }else {
                ans[f2] = n;
                f2 += 2;
            }
        }
        return ans;

    }
}

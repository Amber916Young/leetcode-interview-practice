package StringListHash;

import java.util.Arrays;

/**
 * @ClassName:largestPerimeter
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/largest-perimeter-triangle/
 * @Date: 20/11/2022 19:44
 * @Version: v1.0
 */
public class largestPerimeter {

    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length - 3; i >= 0; --i)
            if (nums[i] + nums[i+1] > nums[i+2])
                return nums[i] + nums[i+1] + nums[i+2];
        return 0;
    }


}

package StringListHash;

import java.util.Arrays;

/**
 * @ClassName:maxProductDifference
 * @Auther: yyj
 * @Description:
 * @Date: 19/12/2022 13:47
 * @Version: v1.0
 */
public class maxProductDifference {

    public int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        int n1 = nums[0]*nums[1];
        int n2 = nums[nums.length-1]*nums[nums.length-2];
        return n2 -n1;
    }
}

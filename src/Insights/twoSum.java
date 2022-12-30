package Insights;

import java.util.*;

/**
 * @ClassName:twoSum
 * @Auther: yyj
 * @Description:
 * @Date: 29/12/2022 22:49
 * @Version: v1.0
 */
public class twoSum {


    /**
     * Example 1:
     *
     * Input: nums = [2,7,11,15], target = 9
     * Output: [0,1]
     * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
     * Example 2:
     *
     * Input: nums = [3,2,4], target = 6
     * Output: [1,2]
     * Example 3:
     *
     * Input: nums = [3,3], target = 6
     * Output: [0,1]
     */
    public static void main(String[] args) {
        twoSum(new int[]{2,7,11,15},9);
    }
    static public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            int sum = target - nums[i];
            if(map.containsKey(sum)){
                return new int[]{map.get(sum),i};
            }
            map.put(nums[i],i);
        }
        return new int[]{};

    }
}

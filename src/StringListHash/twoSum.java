package StringListHash;

import java.util.*;

/**
 * @ClassName:twoSum
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/two-sum/
 * @Date: 03/11/2022 11:13
 * @Version: v1.0
 */
public class twoSum {
    public static void main(String[] args) {
        twoSum(new int[]{2,7,11,15},9);
    }
    static public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int sum = target - nums[i];
            if (map.containsKey(sum)){
                return new int[] { map.get(sum), i };
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}

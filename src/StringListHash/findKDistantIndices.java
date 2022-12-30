package StringListHash;

import java.util.*;

/**
 * @ClassName:findKDistantIndices
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/find-all-k-distant-indices-in-an-array/
 * @Date: 26/12/2022 13:59
 * @Version: v1.0
 */
public class findKDistantIndices {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> res = new ArrayList<>();
        List<Integer> keys = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                keys.add(i);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < keys.size(); j++) {
                if (Math.abs(i - keys.get(j)) <= k) {
                    res.add(i);
                    break;
                }
            }
        }
        return res;
    }

}

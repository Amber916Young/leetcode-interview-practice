package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName:targetIndices
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/find-target-indices-after-sorting-array/
 * @Date: 27/10/2022 12:47
 * @Version: v1.0
 */
public class targetIndices {
    public static void main(String[] args) {
        targetIndices test = new targetIndices();
        test.targetIndices(new int[]{1,2,5,2,3},5);
    }
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        List<Integer> ans = new ArrayList<>();
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cur = nums[mid];
            if (cur == target) {
                int first = mid;
                int last = mid;
                while (first - 1 >= 0 && nums[first - 1] == target) {
                    first--;
                }
                while (last + 1 < nums.length && nums[last + 1] == target) {
                    last++;
                }
                for (int i = first; i <= last; i++) {
                    ans.add(i);
                }
                return ans;
            } else if (cur > target) {
                right--;
            } else {
                left++;
            }
        }
        return ans;

    }
}

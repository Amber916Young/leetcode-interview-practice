package BinarySearch;

/**
 * @ClassName:search88
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
 * @Date: 17/11/2022 11:22
 * @Version: v1.0
 */
public class search88 {

    public static void main(String[] args) {
//        search(new int[]{3,1},1);
    }
    //Input: nums = [2,5,6,0,0,1,2], target = 0
    public boolean search(int[] nums, int target) {
        if (null == nums || 0 == nums.length) return false;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            while (start < end && nums[start] == nums[start + 1])
                ++start;
            while (start < end && nums[end] == nums[end - 1])
                --end;
            int mid = start + (end - start) / 2;
            if (target == nums[mid]) {
                return true;
            }
            if (nums[mid] >= nums[start]) {
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target <= nums[end] && target > nums[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return false;
    }
}

package BinarySearch;

/**
 * @ClassName:singleNonDuplicate
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/single-element-in-a-sorted-array/
 * @Date: 16/11/2022 12:47
 * @Version: v1.0
 */
public class singleNonDuplicate {
    public static void main(String[] args) {
//        singleNonDuplicate(new int[]{1, 1, 2});
    }

    public int singleNonDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == nums[mid - 1]) {
                if ((mid + 1) % 2 == 0) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            } else {
                if ((mid + 1) % 2 == 0) {
                    end = mid - 1;
                } else {
                    start = mid;
                }
            }
        }
        return nums[start];
    }
}

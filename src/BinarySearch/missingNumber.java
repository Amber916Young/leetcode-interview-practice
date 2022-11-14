package BinarySearch;

import java.util.Arrays;

/**
 * @ClassName:missingNumber
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/missing-number/
 * @Date: 12/11/2022 23:03
 * @Version: v1.0
 */
public class missingNumber {
    public static void main(String[] args) {
        missingNumber(new int[]{0,1});
    }
    static public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length - 1;
        while (start <= end){
            int mid = start + (end - start) / 2;
            if(nums[mid] == mid) {
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        return start;
    }
}

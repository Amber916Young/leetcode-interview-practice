package BinarySearch;

/**
 * @ClassName:pivotIndex
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/find-pivot-index/
 * @Date: 02/11/2022 12:25
 * @Version: v1.0
 */
public class pivotIndex {

    /**
     * Example 1:
     *
     * Input: nums = [1,7,3,6,5,6]
     * Output: 3
     * Explanation:
     * The pivot index is 3.
     * Left sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11
     * Right sum = nums[4] + nums[5] = 5 + 6 = 11
     * Example 2:
     *
     * Input: nums = [1,2,3]
     * Output: -1
     * Explanation:
     * There is no index that satisfies the conditions in the problem statement.
     * Example 3:
     *
     * Input: nums = [2,1,-1]
     * Output: 0
     * Explanation:
     * The pivot index is 0.
     * Left sum = 0 (no elements to the left of index 0)
     * Right sum = nums[1] + nums[2] = 1 + -1 = 0
     * @param nums
     * @return
     */
    public int pivotIndex(int[] nums) {
        // if(nums.length==1) return 0;
        // int mid =0;
        // while (mid<nums.length){
        //     int right=0;
        //     int left=0;
        //     for(int i=0;i<mid;i++){
        //         right +=nums[i];
        //     }
        //     for(int i=mid+1;i<nums.length;i++){
        //         left +=nums[i];
        //     }
        //     if(left==right) return mid;
        //     mid++;
        // }
        // return -1;

        int sum = 0, leftsum = 0;
        for (int x: nums) sum += x;
        for (int i = 0; i < nums.length; ++i) {
            if (leftsum == sum - leftsum - nums[i]) return i;
            leftsum += nums[i];
        }
        return -1;
    }
}

package Graphs;

/**
 * @ClassName:findDuplicate
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/find-the-duplicate-number/
 * @Date: 26/10/2022 22:55
 * @Version: v1.0
 */
public class findDuplicate {

    /**
     * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
     *
     * There is only one repeated number in nums, return this repeated number.
     *
     * You must solve the problem without modifying the array nums and uses only constant extra space.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [1,3,4,2,2]
     * Output: 2
     * Example 2:
     *
     * Input: nums = [3,1,3,4,2]
     * Output: 3
     * **/
    public static void main(String[] args) {
        findDuplicate(new int[]{1,3,4,2,2});
    }
    public static int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while (slow != fast);

        fast = 0;
        while(slow!=fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;

    }
}

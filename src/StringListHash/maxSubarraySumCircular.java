package StringListHash;

/**
 * @ClassName:maxSubarraySumCircular
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/maximum-sum-circular-subarray/
 * @Date: 09/11/2022 11:41
 * @Version: v1.0
 */
public class maxSubarraySumCircular {


    public static void main(String[] args) {
        maxSubarraySumCircular( new int[]{1,-2,3,-2});
    }

    // Kadane's Algorithm
   static public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int total = 0;
        int min_sum = Integer.MAX_VALUE;
        int max_sum = Integer.MIN_VALUE;
        int max_sum_cur = 0;
        int min_sum_cur  = 0;
        for(int i =0; i< n  ; i++){
            total += nums[i];
            max_sum_cur = Math.max(max_sum_cur + nums[i],nums[i]);
            max_sum = Math.max(max_sum_cur,max_sum);

            min_sum_cur = Math.min(min_sum_cur + nums[i],nums[i]);
            min_sum = Math.min(min_sum_cur,min_sum);
        }
        if(max_sum > 0)
            return Math.max(total- min_sum , max_sum);

        return max_sum;
    }
}

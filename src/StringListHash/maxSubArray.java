package StringListHash;

/**
 * @ClassName:maxSubArray
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/maximum-subarray/
 * @Date: 09/11/2022 11:14
 * @Version: v1.0
 */
public class maxSubArray {

    public static void main(String[] args) {
        maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
    }
    //Kadane's Algorithm
   static public int maxSubArray(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        if(n == 1) return nums[0];
        int sum_cur = nums[0];
        int max_sum = nums[0];
        for(int i=1;i<n;i++){
            sum_cur=  Math.max( nums[i], sum_cur + nums[i]);
//            if(sum_cur < 0) sum_cur = nums[i];
//            else sum_cur += nums[i];
            if(sum_cur > max_sum) max_sum = sum_cur;
            System.out.println(i+"sum_cur"+sum_cur + "max_sum"+max_sum);
        }
        return max_sum;
    }
}

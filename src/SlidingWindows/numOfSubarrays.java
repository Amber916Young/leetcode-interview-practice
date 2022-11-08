package SlidingWindows;

import java.util.*;

/**
 * @ClassName:numOfSubarrays
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/
 * @Date: 08/11/2022 13:29
 * @Version: v1.0
 */
public class numOfSubarrays {

    public static void main(String[] args) {
        numOfSubarrays(new int[]{11,13,17,23,29,31,7,5,2,3},3,5);
    }
    /**
     * Given an array of integers arr and two integers k and threshold,
     * return the number of sub-arrays of size k and average greater than or equal to threshold.
     *
     * Input: arr = [2,2,2,2,5,5,5,8], k = 3, threshold = 4
     * Output: 3
     * Explanation: Sub-arrays [2,5,5],[5,5,5] and [5,5,8] have averages 4, 5 and 6 respectively.
     * All other sub-arrays of size 3 have averages less than 4 (the threshold).
     * @param arr
     * @param k
     * @param threshold
     * @return
     */

    static public int numOfSubarrays(int[] arr, int k, int threshold) {
        int left = 0 ,ans = 0;
        int sum = 0;
        int target = threshold * k;
        for(int i =0;i<arr.length;i++){
            sum += arr[i];
            while ( i - left +1 >= k){
                if(sum >= target || sum - arr[left] >= target ) ans++;
                sum -= arr[left];
                left++;
            }
        }
        return ans;
    }
}

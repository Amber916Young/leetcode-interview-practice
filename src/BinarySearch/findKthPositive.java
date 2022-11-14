package BinarySearch;


/**
 * @ClassName:findKthPositive
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/kth-missing-positive-number/
 * @Date: 12/11/2022 23:35
 * @Version: v1.0
 */
public class findKthPositive {

    public static void main(String[] args) {
        findKthPositive(new int[]{2,3,4,7,11},5);
    }


    //Input: arr = [2,3,4,7,11], k = 5
    //Output: 9
    //Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...].
    // The 5th missing positive integer is 9.
   static public int findKthPositive(int[] arr, int k) {
        int start = 0;
        int end = arr.length;
       while(start<end){
            int mid = start + (end - start)/2;
            if(arr[mid] - (mid+1) >= k){
                end = mid;
            } else{
                start = mid + 1;
            }
        }
        return start+k;
    }
}

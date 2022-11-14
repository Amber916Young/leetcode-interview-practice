package BinarySearch;

/**
 * @ClassName:missingElement
 * @Auther: yyj
 * @Description:
 * @Date: 13/11/2022 16:13
 * @Version: v1.0
 */
public class missingElement {


    public static void main(String[] args) {
     System.out.println(   missingElement(new int[]{4,7,9,10},3));
    }
    /**
     * Input: A = [4,7,9,10], K = 1
     * Output: 5
     * Explanation:
     * The first missing number is 5.
     */
   static public int missingElement(int[] nums, int k) {
       int len = nums.length;
       int end = nums.length;
       int missCount = nums[len - 1] - nums[0] + 1 - len;
       if (missCount < k) return nums[end - 1] + (k - missCount);
       int start = 0;
       while (start < end) {
           int mid = start + (end - start) / 2;
           int missingNumber = nums[mid] - nums[start] - (mid - start);
           if (missingNumber >= k) {
               end = mid;
           } else {
               k -= missingNumber;
               start = mid ;
           }
       }

       return nums[start] + k;
   }
}
package BinarySearch;

/**
 * @ClassName:minimumSize
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/minimum-limit-of-balls-in-a-bag/
 * @Date: 14/11/2022 12:16
 * @Version: v1.0
 */
public class minimumSize {
    public static void main(String[] args) {
        minimumSize(new int[]{2,4,8,2},4);
    }
    static public int minimumSize(int[] nums, int maxOperations) {
        int start = 1, end  = 1;
        for(int i : nums){
            end = Math.max(end,i);
        }
        while (start < end){
            int mid = start + (end - start)/2;
            int totalOperations = 0;
            for(int i : nums){
                totalOperations+=(i-1)/mid;
            }
            if(totalOperations>maxOperations){
                start=mid+1;
            } else{
                end=mid;
            }
        }
        return start;
    }
}

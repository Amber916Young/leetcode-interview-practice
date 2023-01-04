package Mock;

/**
 * @ClassName:searchInsert
 * @Auther: yyj
 * @Description:
 * @Date: 01/01/2023 19:14
 * @Version: v1.0
 */
public class searchInsert {
    public static void main(String[] args) {

        searchInsert(new int[]{1,3,5,6},7);
    }

    //1,3,5,6 5
    static public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        int start = 0;
        int end = len - 1;
        if (nums[end] < target) {
            return len;
        }
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            }
        }
        return start;
    }
}

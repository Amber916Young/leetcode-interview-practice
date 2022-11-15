package BinarySearch;

/**
 * @ClassName:longestOnes
 * @Auther: yyj
 * @Description:
 * @Date: 14/11/2022 20:24
 * @Version: v1.0
 */
public class longestOnes {
    public static void main(String[] args) {
        longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0},2);
    }

    static public int longestOnes(int[] nums, int k) {
        int j = 0;
        int window_size = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) k--;
            while (k < 0) {
                if (nums[j] == 0) k++;
                j++;
            }
            window_size = Math.max(window_size, i - j + 1);
        }
        return window_size;
    }
}

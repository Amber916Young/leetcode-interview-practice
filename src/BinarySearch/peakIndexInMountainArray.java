package BinarySearch;

/**
 * @ClassName:peakIndexInMountainArray
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/peak-index-in-a-mountain-array/
 * @Date: 27/10/2022 13:41
 * @Version: v1.0
 */
public class peakIndexInMountainArray {
    public static void main(String[] args) {
        peakIndexInMountainArray(new int[]{1, 2, 3, 4, 1});
    }


    public static int peakIndexInMountainArray(int[] arr) {

        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < arr[mid + 1])
                left = mid + 1;
            else
                right = mid;
        }

        return left;

    }
}

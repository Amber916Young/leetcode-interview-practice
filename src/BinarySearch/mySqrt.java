package BinarySearch;

/**
 * @ClassName:mySqrt
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/sqrtx/
 * @Date: 20/11/2022 15:11
 * @Version: v1.0
 */
public class mySqrt {

    public static void main(String[] args) {
        mySqrt(8);
    }
    static public int mySqrt(int num) {
        if (num == 1) return 1;
        long start = 1;
        long end = num/2;
        while (start <= end) {
            long mid = start + (end - start) / 2;
            if (mid * mid == num) {
                return (int) mid;
            } else if (mid * mid < num) {
                start = mid + 1;
            } else {
                end = mid -1;
            }
        }
        return (int) end;
    }
}

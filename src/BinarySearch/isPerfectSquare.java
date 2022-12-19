package BinarySearch;

/**
 * @ClassName:isPerfectSquare
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/valid-perfect-square/
 * @Date: 20/11/2022 14:58
 * @Version: v1.0
 */
public class isPerfectSquare {


    public static void main(String[] args) {
        isPerfectSquare(808201);
    }
  static   public boolean isPerfectSquare(int num) {
      if (num == 1) return true;
      long start = 1;
      long end = num;
      while (start <= end) {
          long mid = start + (end - start) / 2;
          if (mid * mid == num) {
              return true;
          } else if (mid * mid < num) {
              start = mid + 1;
          } else {
              end = mid - 1;
          }

      }
      return false;
  }
}

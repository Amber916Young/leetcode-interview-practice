package BinarySearch;

import java.util.Arrays;

/**
 * @ClassName:minDays
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/
 * @Date: 14/11/2022 10:44
 * @Version: v1.0
 */
public class minDays {

    public static void main(String[] args) {
//        minDays(new int[]{1,10,3,10,2},3,1);
    }

    /**
     * bloomDay = [1,10,3,10,2], m = 3, k = 1
     *
     * @param bloomDay
     * @param m        bouquets
     * @param k        adjacent flowers
     * @return
     */
    public int minDays(int[] bloomDay, int m, int k) {
        long mul = m * (long) k;
        if (mul > bloomDay.length) return -1;
        int left = 1, right = 1;
        for (int i = 0; i < bloomDay.length; i++) {
            right = Math.max(right, bloomDay[i]);
            left = Math.min(left, bloomDay[i]);
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isWork(mid, bloomDay, k, m)) {
                right = mid;
            } else
                left = mid + 1;
        }
        return left;
    }

    private boolean isWork(int mid, int[] bloomDay, int k, int m) {
        int tmpDays = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] > mid) tmpDays = 0;
            else {
                tmpDays++;
                if (tmpDays == k) {
                    m--;
                    tmpDays = 0;
                }
            }
        }
        return m <= 0;
    }


}

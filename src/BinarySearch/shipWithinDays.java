package BinarySearch;

import java.util.Arrays;

/**
 * @ClassName:shipWithinDays
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
 * @Date: 15/11/2022 15:50
 * @Version: v1.0
 */
public class shipWithinDays {

    public static void main(String[] args) {
        shipWithinDays shipWithinDays = new shipWithinDays();
        shipWithinDays.shipWithinDays(new int[]{1, 2, 3, 1, 1}, 4);
    }

    public int shipWithinDays(int[] weights, int days) {
        int start = 0;
        int end = 0;
        for (int i = 0; i < weights.length; i++) {
            if (weights[i] > start) start = weights[i]; // max
            end += weights[i];  // sum
        }
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (isPossible(mid, weights, days)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    private boolean isPossible(int mid, int[] weights, int days) {
        int count = 0;
        for (int i : weights) {
            if (count + i <= mid) {
                count += i;
            } else {
                days--;
                if (days < 0) return false;
                count = i;
            }
        }
        days--;
        return days >= 0;
    }
}

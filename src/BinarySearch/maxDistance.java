package BinarySearch;

import java.util.Arrays;

/**
 * @ClassName:maxDistance
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/magnetic-force-between-two-balls/
 * @Date: 15/11/2022 11:26
 * @Version: v1.0
 */
public class maxDistance {
    public static void main(String[] args) {
//        maxDistance(new int[]{5, 4, 3, 2, 1, 1000000000}, 2);
    }


    boolean isPossible(int[] position, int m, int mid) {
        int count = 1;
        int placed = position[0];
        for (int i = 1; i < position.length; i++) {
            if (position[i] - placed >= mid) {
                placed = position[i];
                count++;
            }
            if (count == m) {
                return true;
            }
        }
        return false;
    }

    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int start = 1;
        int end = position[position.length - 1] - position[0];
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isPossible(position, m, mid)) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start - 1;
    }
}

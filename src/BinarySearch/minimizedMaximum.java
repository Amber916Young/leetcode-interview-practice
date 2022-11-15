package BinarySearch;

import java.util.HashMap;

/**
 * @ClassName:minimizedMaximum
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/minimized-maximum-of-products-distributed-to-any-store/
 * @Date: 15/11/2022 14:09
 * @Version: v1.0
 */
public class minimizedMaximum {
    public static void main(String[] args) {
        minimizedMaximum(6, new int[]{11, 6});
    }

    //2064. Minimized Maximum of Products Distributed to Any Store

    /**
     * Input: n = 6, quantities = [11,6]
     * Output: 3
     * Explanation: One optimal way is:
     * - The 11 products of type 0 are distributed to the first four stores in these amounts: 2, 3, 3, 3
     * - The 6 products of type 1 are distributed to the other two stores in these amounts: 3, 3
     * The maximum number of products given to any store is max(2, 3, 3, 3, 3, 3) = 3.
     */
    static public int minimizedMaximum(int n, int[] quantities) {
        int start = 1;
        int end = Integer.MAX_VALUE / 2;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (isHelper(mid, quantities, n)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    static boolean isHelper(int mid, int[] quantities, int n) {
        int count = 0;
        for (int i : quantities) {
            if (i % mid == 0) {
                count += i / mid;
            } else
                count += i / mid + 1;
        }
        return count <= n;
    }
}

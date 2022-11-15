package BinarySearch;

import java.util.HashMap;

/**
 * @ClassName:maximumCandies
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/maximum-candies-allocated-to-k-children/
 * @Date: 15/11/2022 18:14
 * @Version: v1.0
 */
public class maximumCandies {

    public static void main(String[] args) {
        maximumCandies maximumCandies = new maximumCandies();
        maximumCandies.maximumCandies(new int[]{5, 6, 4, 10, 10, 1, 1, 2, 2, 2}, 9);
//        maximumCandies.maximumCandies(new int[]{5,8,6}, 3);
    }
//2226. Maximum Candies Allocated to K Children

    /**
     * Input: candies = [5,8,6], k = 3
     * Output: 5
     * Explanation: We can divide candies[1] into 2 piles of size 5 and 3, and candies[2] into 2 piles of size 5 and 1.
     * We now have five piles of candies of sizes 5, 5, 3, 5, and 1.
     * We can allocate the 3 piles of size 5 to 3 children. It can be proven that each child cannot receive more than 5 candies.
     */
    public int maximumCandies(int[] candies, long k) {
        int start = 1;
        int end = 1;
        long sum = 0;
        for (int i : candies) {
            end = Math.max(end, i);
            sum += i;
        }
        int res = 0;
        if (sum < k) return 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isPossible(mid, candies, k)) {
                res = Math.max(res, mid);
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return res;
    }

    private boolean isPossible(int mid, int[] candies, long k) {
        long count = 0;
        for (int i = 0; i < candies.length; i++) {
            count += candies[i] / mid;
        }
        return count >= k;
    }
}

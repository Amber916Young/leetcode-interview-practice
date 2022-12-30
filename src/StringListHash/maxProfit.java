package StringListHash;

/**
 * @ClassName:maxProfit
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 * @Date: 26/12/2022 15:29
 * @Version: v1.0
 */
public class maxProfit {

    //714. Best Time to Buy and Sell Stock with Transaction Fee

    /**
     * Input: prices = [1,3,2,8,4,9], fee = 2
     * Output: 8
     * Explanation: The maximum profit can be achieved by:
     * - Buying at prices[0] = 1
     * - Selling at prices[3] = 8
     * - Buying at prices[4] = 4
     * - Selling at prices[5] = 9
     * The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
     * @param prices
     * @param fee transaction fee
     * @return
     */
    public int maxProfit(int[] prices, int fee) {
        int hold = 0, sold = 0;
        for (int i = 0; i < prices.length; i++) {
            int temp_hold = hold, temp_sold = sold;
            int price = prices[i];
            hold = Math.max(temp_hold,temp_sold -price );
            sold = Math.max(temp_sold,temp_hold + price -fee );
        }
        return sold;

    }
}

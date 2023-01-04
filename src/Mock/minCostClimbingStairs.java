package Mock;

/**
 * @ClassName:minCostClimbingStairs
 * @Auther: yyj
 * @Description:
 * @Date: 30/12/2022 17:01
 * @Version: v1.0
 */
public class minCostClimbingStairs {
    //1,100,1,1,1,100,1,1,100,1
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for(int i =2;i<cost.length;i++){
            int step1 = cost[i] + dp[i - 1];
            int step2 = cost[i] + dp[i - 2];
            dp[i] = Math.min(step1, step2);
        }
        return Math.min(dp[cost.length - 1], dp[cost.length - 2]);

    }
}

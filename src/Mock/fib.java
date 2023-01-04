package Mock;

/**
 * @ClassName:fib
 * @Auther: yyj
 * @Description:
 * @Date: 02/01/2023 18:59
 * @Version: v1.0
 */
public class fib {

    public int fib(int n) {
        if (n == 0){
            return 0;
        }else if (n == 1 || n == 2){
            return 1;
        }
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for(int i = 3;i <= n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];


    }
}